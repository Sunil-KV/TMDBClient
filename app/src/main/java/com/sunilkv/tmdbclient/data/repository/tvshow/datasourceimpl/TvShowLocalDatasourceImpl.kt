package com.sunilkv.tmdbclient.data.repository.tvshow.datasourceimpl

import com.sunilkv.tmdbclient.data.db.TvshowDao
import com.sunilkv.tmdbclient.data.model.tvshow.TvShow
import com.sunilkv.tmdbclient.data.repository.tvshow.datasource.TvShowLocalDatasource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TvShowLocalDatasourceImpl(private val tvshowDao: TvshowDao):TvShowLocalDatasource {
    override suspend fun getTvshowsFromDB(): List<TvShow> {
        return tvshowDao.getAllTvshows()
    }

    override suspend fun saveTvshowsToDB(tvshows: List<TvShow>) {
        CoroutineScope(Dispatchers.IO).launch {
            tvshowDao.saveTvshows(tvshows)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            tvshowDao.deleteTvshows()
        }

    }
}