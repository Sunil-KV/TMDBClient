package com.sunilkv.tmdbclient.domain.usecases

import com.sunilkv.tmdbclient.data.model.tvshow.TvShow
import com.sunilkv.tmdbclient.domain.repository.TvshowRepository

class GetTvshowsUsecase(private val tvshowRepository: TvshowRepository) {
    suspend fun execute() : List<TvShow>? = tvshowRepository.getTvshows()
}