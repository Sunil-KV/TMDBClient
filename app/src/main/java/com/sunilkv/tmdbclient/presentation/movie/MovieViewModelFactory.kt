package com.sunilkv.tmdbclient.presentation.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sunilkv.tmdbclient.domain.usecases.GetMoviesUsecase
import com.sunilkv.tmdbclient.domain.usecases.UpdateMoviesUsecase

class MovieViewModelFactory(
    private val getMoviesUsecase: GetMoviesUsecase,
    private val updateMoviesUsecase: UpdateMoviesUsecase
) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MovieViewModel(getMoviesUsecase, updateMoviesUsecase) as T
    }
}