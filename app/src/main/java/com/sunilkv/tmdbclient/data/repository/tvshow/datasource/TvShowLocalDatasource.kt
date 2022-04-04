package com.sunilkv.tmdbclient.data.repository.tvshow.datasource

import com.sunilkv.tmdbclient.data.model.tvshow.TvShow

interface TvShowLocalDatasource {
    suspend fun getTvshowsFromDB() : List<TvShow>
    suspend fun saveTvshowsToDB(tvshows:List<TvShow>)
    suspend fun clearAll()
}