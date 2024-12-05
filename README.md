**World News App 📰**

World News App is a straightforward news aggregator that utilizes the [NewsAPI](https://newsdata.io/) to fetch top news headlines. Its primary purpose is to demonstrate cutting-edge libraries and tools that simplify the development of high-quality Android applications.

The codebase focuses on following key things:
- Offline first ✈️
- Kotlin 💜
- Jetpack Compose
- Koin
- Ktor
- MVI Clean Architecture

The goal is to maintain a minimalist app design while showcasing innovative libraries and tools, thereby streamlining the development of premium Android applications.

<img alt="News Main Page" height="450px" src="https://github.com/user-attachments/assets/bbb2ce69-99f3-4fc5-a895-1274ea2499f7" />    <img alt="News Details Page" height="450px" src="https://github.com/user-attachments/assets/8ea79ede-b633-4b78-92eb-807a297d57f8" />

# Development Setup 💻

You will require latest version of Android Studio 3.0 (or newer) to be able to build the app

## API key 🔑
You'll need to provide API key to fetch the news from the News Service (API). Currently the news is fetched from [NewsAPI](https://newsdata.io/)

- Generate an API key from [NewsAPI](https://newsdata.io/)
- Go to the `NewsRepositoryImpl` under the package named -> `com.michael.worldnews.core.data` in our project app folder
- Add the API key you generated as shown below [Make sure to keep the double quotes]:
```
    private val apiKey = "<INSERT_YOUR_API_KEY>"
```
- Build the app 
- Enjoy!! 😃 


## Libraries and tools 🛠

News App uses libraries and tools used to build Modern Android application, mainly part of Android Jetpack.

- [Kotlin](https://kotlinlang.org/) first
- [Room](https://kotlinlang.org/docs/reference/coroutines-overview.html)
- Architecture components
- [Coil]() for image loading
- [Koin](https://developer.android.com/training/dependency-injection) for dependency injection
- [Ktor](https://square.github.io/retrofit/)
- Other [Android Jetpack](https://developer.android.com/jetpack) components


## Architecture 🌵

The app uses MVI [Model-View-Intent] architecture to make the app's codebase scalable and flexible to embrace new ideas and updates.

Read more: 
- [MVI Architecture Pattern in Android](https://medium.com/@mohammedkhudair57/mvi-architecture-pattern-in-android-0046bf9b8a2e)
- [Guide to app architecture](https://developer.android.com/jetpack/docs/guide)

![MVI architecture](https://github.com/user-attachments/assets/1e4f9bb0-2a70-4c55-81d1-8c70e917826f)


## Limitations:
- Unable to fetch news contents: This is because I'm using the free plan of the API key 🗝, upgrade to paid plan if you wish.

## Credit 🫂
- [Ahmed Guedmioui](https://youtube.com/playlist?list=PLy1MhTvkr6qKvRjSrc2utx6B1NdxAp_tf&si=91CUucMFV1_K3GlV) for creating an awesome tutorial guide.
- [favourdev1 a.k.a Baby](https://github.com/favourdev1) for pushing me to write this README.
