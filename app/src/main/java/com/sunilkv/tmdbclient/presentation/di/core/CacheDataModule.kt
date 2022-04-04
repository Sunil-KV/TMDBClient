package com.sunilkv.tmdbclient.presentation.di.core

import com.sunilkv.tmdbclient.data.repository.artist.ArtistCacheDataSource
import com.sunilkv.tmdbclient.data.repository.artist.datasourceimpl.ArtistCacheDatasourceImpl
import com.sunilkv.tmdbclient.data.repository.movie.datasource.MovieCacheDatasource
import com.sunilkv.tmdbclient.data.repository.movie.datasourceImpl.MovieCacheDatasourceImpl
import com.sunilkv.tmdbclient.data.repository.tvshow.datasource.TvShowCacheDatasource
import com.sunilkv.tmdbclient.data.repository.tvshow.datasourceimpl.TvShowCacheDatasourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheDataModule {

    @Singleton
    @Provides
    fun provideMovieCacheDataSource(): MovieCacheDatasource{
        return MovieCacheDatasourceImpl()
    }

    @Singleton
    @Provides
    fun provideArtistCacheDataSource(): ArtistCacheDataSource{
        return ArtistCacheDatasourceImpl()
    }

    @Singleton
    @Provides
    fun provideTvshowCacheDataSource(): TvShowCacheDatasource{
        return TvShowCacheDatasourceImpl()
    }
}