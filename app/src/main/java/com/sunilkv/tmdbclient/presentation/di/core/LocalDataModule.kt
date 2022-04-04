package com.sunilkv.tmdbclient.presentation.di.core

import com.sunilkv.tmdbclient.data.db.ArtistDao
import com.sunilkv.tmdbclient.data.db.MovieDao
import com.sunilkv.tmdbclient.data.db.TvshowDao
import com.sunilkv.tmdbclient.data.repository.artist.ArtistLocalDataSource
import com.sunilkv.tmdbclient.data.repository.artist.datasourceimpl.ArtistLocalDatasourceImpl
import com.sunilkv.tmdbclient.data.repository.movie.datasource.MovieLocalDatasource
import com.sunilkv.tmdbclient.data.repository.movie.datasourceImpl.MovieLocalDatasourceImpl
import com.sunilkv.tmdbclient.data.repository.tvshow.datasource.TvShowLocalDatasource
import com.sunilkv.tmdbclient.data.repository.tvshow.datasourceimpl.TvShowLocalDatasourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule {

    @Singleton
    @Provides
    fun provideMovieLocalDataSource(movieDao: MovieDao): MovieLocalDatasource{
        return MovieLocalDatasourceImpl(movieDao)
    }

    @Singleton
    @Provides
    fun provideArtistLocalDataSource(artistDao: ArtistDao): ArtistLocalDataSource{
        return ArtistLocalDatasourceImpl(artistDao)
    }

    @Singleton
    @Provides
    fun provideTvshowLocalDataSource(tvshowDao: TvshowDao): TvShowLocalDatasource{
        return TvShowLocalDatasourceImpl(tvshowDao)
    }
}