package com.sunilkv.tmdbclient.domain.repository

import com.sunilkv.tmdbclient.data.model.tvshow.TvShow

interface TvshowRepository {
    suspend fun getTvshows(): List<TvShow>?
    suspend fun updateTvshpws(): List<TvShow>
}