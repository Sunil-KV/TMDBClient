package com.sunilkv.tmdbclient.presentation.di.movie

import com.sunilkv.tmdbclient.domain.usecases.GetArtistsUsecase
import com.sunilkv.tmdbclient.domain.usecases.GetMoviesUsecase
import com.sunilkv.tmdbclient.domain.usecases.UpdateArtistUsecase
import com.sunilkv.tmdbclient.domain.usecases.UpdateMoviesUsecase
import com.sunilkv.tmdbclient.presentation.artist.ArtistViewModelFactory
import com.sunilkv.tmdbclient.presentation.movie.MovieViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MovieModule {

    @MovieScope
    @Provides
    fun provideMovieViewModelFactory(
        getMoviesUsecase: GetMoviesUsecase,
        updateMoviesUsecase: UpdateMoviesUsecase
    ): MovieViewModelFactory{
        return MovieViewModelFactory(getMoviesUsecase,
            updateMoviesUsecase
        )
    }
}