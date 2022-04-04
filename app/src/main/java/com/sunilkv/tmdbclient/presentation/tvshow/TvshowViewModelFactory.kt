package com.sunilkv.tmdbclient.presentation.tvshow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sunilkv.tmdbclient.domain.usecases.GetTvshowsUsecase
import com.sunilkv.tmdbclient.domain.usecases.UpdateTvshowsUsecase

class TvshowViewModelFactory(
    private val getTvshowsUsecase: GetTvshowsUsecase,
    private val updateTvshowsUsecase: UpdateTvshowsUsecase
) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return TvshowViewModel(getTvshowsUsecase, updateTvshowsUsecase) as T
    }
}