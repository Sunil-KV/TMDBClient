package com.sunilkv.tmdbclient.presentation.tvshow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.sunilkv.tmdbclient.data.model.tvshow.TvShow
import com.sunilkv.tmdbclient.domain.usecases.GetTvshowsUsecase
import com.sunilkv.tmdbclient.domain.usecases.UpdateTvshowsUsecase

class TvshowViewModel(
    private val getTvshowsUsecase: GetTvshowsUsecase,
    private val updateTvshowsUsecase: UpdateTvshowsUsecase
): ViewModel() {
    fun getTvshows() = liveData {
        var tvshowlist : List<TvShow>? = getTvshowsUsecase.execute()
        emit(tvshowlist)
    }
    fun updateTvshows() = liveData {
        var updatetvshows : List<TvShow>? = updateTvshowsUsecase.execute()
        emit(updatetvshows)
    }
}