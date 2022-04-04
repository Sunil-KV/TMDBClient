package com.sunilkv.tmdbclient.presentation.di.core

import com.sunilkv.tmdbclient.data.repository.artist.ArtistCacheDataSource
import com.sunilkv.tmdbclient.data.repository.artist.ArtistLocalDataSource
import com.sunilkv.tmdbclient.data.repository.artist.ArtistRemoteDataSource
import com.sunilkv.tmdbclient.data.repository.artist.ArtistRepositoryImpl
import com.sunilkv.tmdbclient.data.repository.movie.MovieRepositoryImpl
import com.sunilkv.tmdbclient.data.repository.movie.datasource.MovieCacheDatasource
import com.sunilkv.tmdbclient.data.repository.movie.datasource.MovieLocalDatasource
import com.sunilkv.tmdbclient.data.repository.movie.datasource.MovieRemoteDatasource
import com.sunilkv.tmdbclient.data.repository.tvshow.TvshowRepositoryImpl
import com.sunilkv.tmdbclient.data.repository.tvshow.datasource.TvShowCacheDatasource
import com.sunilkv.tmdbclient.data.repository.tvshow.datasource.TvShowLocalDatasource
import com.sunilkv.tmdbclient.data.repository.tvshow.datasource.TvShowRemoteDatasource
import com.sunilkv.tmdbclient.domain.repository.ArtistRepository
import com.sunilkv.tmdbclient.domain.repository.MovieRepository
import com.sunilkv.tmdbclient.domain.repository.TvshowRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideMovieRepository(
        movieRemoteDatasource: MovieRemoteDatasource,
        movieLocalDatasource: MovieLocalDatasource,
        movieCacheDatasource: MovieCacheDatasource
    ): MovieRepository {
        return MovieRepositoryImpl(
            movieLocalDatasource,
            movieRemoteDatasource,
            movieCacheDatasource
        )
    }


    @Singleton
    @Provides
    fun provideArtistRepository(
        artistRemoteDataSource: ArtistRemoteDataSource,
        artistLocalDataSource: ArtistLocalDataSource,
        artistCacheDataSource: ArtistCacheDataSource
    ): ArtistRepository {
        return ArtistRepositoryImpl(
            artistLocalDataSource,
            artistCacheDataSource,
            artistRemoteDataSource
        )
    }

    @Singleton
    @Provides
    fun provideTvshowRepository(
        tvShowRemoteDatasource: TvShowRemoteDatasource,
        tvShowLocalDatasource: TvShowLocalDatasource,
        tvShowCacheDatasource: TvShowCacheDatasource
    ): TvshowRepository {
        return TvshowRepositoryImpl(
            tvShowLocalDatasource,
            tvShowRemoteDatasource,
            tvShowCacheDatasource
        )
    }
}