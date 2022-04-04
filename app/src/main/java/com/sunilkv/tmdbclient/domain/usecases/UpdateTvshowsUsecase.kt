package com.sunilkv.tmdbclient.domain.usecases

import com.sunilkv.tmdbclient.data.model.tvshow.TvShow
import com.sunilkv.tmdbclient.domain.repository.TvshowRepository

class UpdateTvshowsUsecase(private val tvshowRepository: TvshowRepository) {
    suspend fun execute() : List<TvShow> = tvshowRepository.updateTvshpws()
}