package com.michael.worldnews.core.data

import com.michael.worldnews.core.data.local.ArticlesDao
import com.michael.worldnews.core.data.remote.NewsListDto
import com.michael.worldnews.core.domain.Article
import com.michael.worldnews.core.domain.NewsList
import com.michael.worldnews.core.domain.NewsRepository
import com.michael.worldnews.core.domain.NewsResult
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.utils.io.CancellationException
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlin.collections.get

class NewsRepositoryImpl(
    private val httpClient: HttpClient,
    private val dao: ArticlesDao
) : NewsRepository {

    private val tag = "NewsRepository: "
    private val baseUrl = "https://newsdata.io/api/1/latest"
    private val apiKey = "pub_607153f5769f041d3752e2e62191f27373bf3"

    private suspend fun getLocalNews(nextPage: String?): NewsList {
        val localNews = dao.getArticleList()
        println(tag + "getLocalNews: " + localNews.size + " nextPage: " + nextPage)

        val newsList = NewsList(
            nextPage = nextPage,
            articles = localNews.map { it.toArticle() }
        )

        return newsList
    }

    private suspend fun getRemoteNews(nextPage: String?): NewsList {
        val newsListDto: NewsListDto = httpClient.get(baseUrl) {
            parameter("apikey", apiKey)
            parameter("language", "en")
            if (nextPage != null) parameter("page", nextPage)
        }.body()

        println(tag + "getRemoteNews: " + newsListDto.results?.size + " nextPage: " + nextPage)

        return newsListDto.toNewsList()
    }

    override suspend fun getNews(): Flow<NewsResult<NewsList>> {
        return flow {
            val remoteNewsList = try {
                getRemoteNews(null)
            } catch (e: Exception) {
                e.printStackTrace()
                // I don't know what this line does:
                if (e is CancellationException) throw e
                println(tag + "getNews remote exception: " + e.message)
                null
            }

            remoteNewsList?.let {
                dao.clearDatabase()
                dao.upsertArticleList(remoteNewsList.articles.map { it.toArticleEntity() })
                emit(NewsResult.Success(getLocalNews(remoteNewsList.nextPage)))
                return@flow
            }

            val localNewsList = getLocalNews(null)
            if (localNewsList.articles.isNotEmpty()) {
                emit(NewsResult.Success(localNewsList))
                return@flow
            }

            emit(NewsResult.Error())

        }
    }

    override suspend fun paginate(nextPage: String?): Flow<NewsResult<NewsList>> {
        return flow {
            val remoteNewsList = try {
                getRemoteNews(nextPage)
            } catch (e: Exception) {
                e.printStackTrace()
                if (e is kotlin.coroutines.cancellation.CancellationException) throw e
                println(tag + "paginate remote exception: " + e.message)
                null
            }

            remoteNewsList?.let {
                dao.upsertArticleList(remoteNewsList.articles.map { it.toArticleEntity() })

                // not getting them from the database like getNews()
                // because we will also get old items that we already have before paginating
                emit(NewsResult.Success(remoteNewsList))
                return@flow
            }
        }
    }


    override suspend fun getArticle(articleId: String): Flow<NewsResult<Article>> {
        return flow {

            dao.getArticle(articleId)?.let { localArticle ->
                println(tag + "getArticle local " + localArticle.articleId)
                emit(NewsResult.Success(localArticle.toArticle()))
                return@flow
            }

            try {
                val response: NewsListDto = httpClient.get(baseUrl) {
                    parameter("apikey", apiKey)
                    parameter("id", articleId)
                }.body()

                println(tag + "getArticle remote " + response.results?.size)

                if (response.results?.isNotEmpty() == true) {
                    emit(NewsResult.Success(response.results[0].toArticle()))
                } else {
                    emit(NewsResult.Error())
                }

            } catch (e: Exception) {
                e.printStackTrace()
                println(tag + e.message)
                emit(NewsResult.Error())
            }
        }
    }
}