package com.sunilkv.tmdbclient.presentation.di.core

import com.sunilkv.tmdbclient.domain.repository.ArtistRepository
import com.sunilkv.tmdbclient.domain.repository.MovieRepository
import com.sunilkv.tmdbclient.domain.repository.TvshowRepository
import com.sunilkv.tmdbclient.domain.usecases.*
import dagger.Module
import dagger.Provides

@Module
class UsecaseModule {

    @Provides
    fun provideGetMoviesUseCase(movieRepository: MovieRepository): GetMoviesUsecase{
        return GetMoviesUsecase(movieRepository)
    }

    @Provides
    fun provideUpdateMoviesUseCase(movieRepository: MovieRepository): UpdateMoviesUsecase{
        return UpdateMoviesUsecase(movieRepository)
    }

    @Provides
    fun provideGetArtistsUseCase(artistRepository: ArtistRepository): GetArtistsUsecase{
        return GetArtistsUsecase(artistRepository)
    }

    @Provides
    fun provideUpdateArtistsUseCase(artistRepository: ArtistRepository): UpdateArtistUsecase{
        return UpdateArtistUsecase(artistRepository)
    }

    @Provides
    fun provideGetTvshowUseCase(tvshowRepository: TvshowRepository): GetTvshowsUsecase{
        return GetTvshowsUsecase(tvshowRepository)
    }

    @Provides
    fun provideUpdateTvshowUseCase(tvshowRepository: TvshowRepository): UpdateTvshowsUsecase{
        return UpdateTvshowsUsecase(tvshowRepository)
    }
}