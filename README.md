# TMDBClient

Hi 👋🏼👋🏼👋🏼
Thanks for checking out my project. For the rest of this document, I will be explaining the
reasons for the technical decisions I made for this case study, the problems I faced, and what
I learnt from them.


## Table of Contents
- [AppInfo](#appinfo)
- [Prerequisite](#prerequisite)
- [Architecture](#architecture)
- [Libraries](#libraries)

##AppInfo

This is a simple Movie Database client App. It retrieves favorite movies, artists and tvshows from TMDB server and displays to user.
User will be able to update the data as and when required.

## Prerequisite
- Minimum Api Level : 26
- compileSdkVersion : 30
- Build System : [Gradle](https://gradle.org/)

## Architecture

The application follows clean architecture because of the benefits it brings to software which includes scalability, maintainability and testability.
It enforces separation of concerns and dependency inversion, where higher and lower level layers all depend on abstractions.

In this project, layers are seperated into 3 modules as below

Presentation, 
Data,
Domain

#### Presentation
I used the MVVM pattern for the presentation layer. The ViewModel handles the UI logic and provides
data via Android architectural component LiveData to the view. The ViewModel talks to
the domain layer with the individual use cases. The reason for using the `Jetpack Viewmodel` is that it survives configuration changes,
and thus ensures that the view state is persisted across screen rotation.

#### Domain
The domain layer contains the app business logic. 
Usecases which represent a single unit of business logic are also defined in the domain layer, and are consumed by the presentation layer.
It also defines the repository interfaces through which it communicates with the data layer.

#### Data
The Data layer implements the repository interfaces defined in domain layer.
and in turn provides interfaces to fetch data from the data sources.
we have local, remote and cache data source.

Retrofit is used to fetch the data from server
Room database is used to store the data.

## Libraries

Libraries used in the application are:

[ViewModel]
[LiveData]
[Data Binding]
[Kotlin Couroutines]
[Glide]
[Dagger]

