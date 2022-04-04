package com.sunilkv.tmdbclient.presentation.di.core

import com.sunilkv.tmdbclient.presentation.di.artist.ArtistSubComponent
import com.sunilkv.tmdbclient.presentation.di.movie.MovieSubComponent
import com.sunilkv.tmdbclient.presentation.di.tvshow.TvshowSubComponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules =[
AppModule::class,
NetModule::class,
DataBaseModule::class,
UsecaseModule::class,
RepositoryModule::class,
RemoteDataModule::class,
LocalDataModule::class,
CacheDataModule::class
])
interface AppComponent {
    fun movieSubComponent():MovieSubComponent.Factory
    fun tvshowSubComponent():TvshowSubComponent.Factory
    fun artistSubComponent(): ArtistSubComponent.Factory
}