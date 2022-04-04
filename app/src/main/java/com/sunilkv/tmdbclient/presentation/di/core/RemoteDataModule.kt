package com.sunilkv.tmdbclient.presentation.di.core

import com.sunilkv.tmdbclient.data.api.TMDBService
import com.sunilkv.tmdbclient.data.db.TMDBDatabase
import com.sunilkv.tmdbclient.data.repository.artist.ArtistRemoteDataSource
import com.sunilkv.tmdbclient.data.repository.artist.datasourceimpl.ArtistRemoteDatasourceImpl
import com.sunilkv.tmdbclient.data.repository.movie.datasource.MovieRemoteDatasource
import com.sunilkv.tmdbclient.data.repository.movie.datasourceImpl.MovieRemoteDatasourceImpl
import com.sunilkv.tmdbclient.data.repository.tvshow.datasource.TvShowRemoteDatasource
import com.sunilkv.tmdbclient.data.repository.tvshow.datasourceimpl.TvShowRemoteDatasourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule(private val apiKey: String) {

    @Singleton
    @Provides
    fun provideMovieRemoteDataSource(tmdbService: TMDBService): MovieRemoteDatasource{
        return MovieRemoteDatasourceImpl(
            tmdbService, apiKey
        )
    }

    @Singleton
    @Provides
    fun provideArtistRemoteDataSource(tmdbService: TMDBService): ArtistRemoteDataSource{
        return ArtistRemoteDatasourceImpl(
            tmdbService, apiKey
        )
    }

    @Singleton
    @Provides
    fun provideTvshowRemoteDataSource(tmdbService: TMDBService): TvShowRemoteDatasource{
        return TvShowRemoteDatasourceImpl(
            tmdbService, apiKey
        )
    }
}