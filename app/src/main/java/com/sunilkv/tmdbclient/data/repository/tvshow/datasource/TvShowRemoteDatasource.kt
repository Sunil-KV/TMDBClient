package com.sunilkv.tmdbclient.data.repository.tvshow.datasource

import com.sunilkv.tmdbclient.data.model.tvshow.TvShowList
import retrofit2.Response

interface TvShowRemoteDatasource {
    suspend fun getTvshows(): Response<TvShowList>
}