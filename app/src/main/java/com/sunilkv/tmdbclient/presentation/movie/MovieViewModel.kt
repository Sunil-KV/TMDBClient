package com.sunilkv.tmdbclient.presentation.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.sunilkv.tmdbclient.data.model.movie.Movie
import com.sunilkv.tmdbclient.domain.usecases.GetMoviesUsecase
import com.sunilkv.tmdbclient.domain.usecases.UpdateMoviesUsecase

class MovieViewModel(
    private val getMoviesUsecase: GetMoviesUsecase,
    private val updateMoviesUsecase: UpdateMoviesUsecase
): ViewModel(){

    fun getMovies() = liveData {
        val movieList = getMoviesUsecase.execute()
        emit(movieList)
    }

    fun updateMovies() = liveData {
        val movieList = updateMoviesUsecase.execute()
        emit(movieList)
    }
}