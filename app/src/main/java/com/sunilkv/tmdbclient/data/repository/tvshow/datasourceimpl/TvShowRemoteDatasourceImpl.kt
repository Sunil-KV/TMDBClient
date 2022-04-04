package com.sunilkv.tmdbclient.data.repository.tvshow.datasourceimpl

import com.sunilkv.tmdbclient.data.api.TMDBService
import com.sunilkv.tmdbclient.data.db.TvshowDao
import com.sunilkv.tmdbclient.data.model.tvshow.TvShowList
import com.sunilkv.tmdbclient.data.repository.tvshow.datasource.TvShowRemoteDatasource
import retrofit2.Response

class TvShowRemoteDatasourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey:String
): TvShowRemoteDatasource {
    override suspend fun getTvshows(): Response<TvShowList> = tmdbService.getPopularTvShows(apiKey)
}