package com.sunilkv.tmdbclient.data.repository.tvshow.datasourceimpl

import com.sunilkv.tmdbclient.data.model.tvshow.TvShow
import com.sunilkv.tmdbclient.data.repository.tvshow.datasource.TvShowCacheDatasource

class TvShowCacheDatasourceImpl: TvShowCacheDatasource {
    private var tvshowlist = ArrayList<TvShow>()
    override suspend fun getTvshowsFrmCache(): List<TvShow> {
        return tvshowlist
    }

    override suspend fun saveTvshowsToCache(tvshows: List<TvShow>) {
        tvshowlist.clear()
        tvshowlist = ArrayList(tvshows)
    }
}