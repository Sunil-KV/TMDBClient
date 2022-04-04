package com.sunilkv.tmdbclient.data.repository.tvshow.datasource


import com.sunilkv.tmdbclient.data.model.tvshow.TvShow

interface TvShowCacheDatasource {
    suspend fun getTvshowsFrmCache() : List<TvShow>
    suspend fun saveTvshowsToCache(tvshows: List<TvShow>)
}