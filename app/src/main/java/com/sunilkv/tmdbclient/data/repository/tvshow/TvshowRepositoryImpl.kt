package com.sunilkv.tmdbclient.data.repository.tvshow

import com.sunilkv.tmdbclient.data.model.tvshow.TvShow
import com.sunilkv.tmdbclient.data.model.tvshow.TvShowList
import com.sunilkv.tmdbclient.data.repository.tvshow.datasource.TvShowCacheDatasource
import com.sunilkv.tmdbclient.data.repository.tvshow.datasource.TvShowLocalDatasource
import com.sunilkv.tmdbclient.data.repository.tvshow.datasource.TvShowRemoteDatasource
import com.sunilkv.tmdbclient.domain.repository.TvshowRepository
import retrofit2.Response

class TvshowRepositoryImpl(
    private val tvShowLocalDatasource: TvShowLocalDatasource,
    private val tvShowRemoteDatasource: TvShowRemoteDatasource,
    private val tvShowCacheDatasource: TvShowCacheDatasource
): TvshowRepository {
    override suspend fun getTvshows(): List<TvShow>? {
        return getTvShowsFromCache()
    }

    override suspend fun updateTvshpws(): List<TvShow> {
        val newListOfTvShows: List<TvShow> = getTvShowsFromDB()
        tvShowLocalDatasource.clearAll()
        tvShowLocalDatasource.saveTvshowsToDB(newListOfTvShows)
        tvShowCacheDatasource.saveTvshowsToCache(newListOfTvShows)
        return newListOfTvShows
    }

    suspend fun getTvShowsFromApi(): List<TvShow> {
        lateinit var tvshowlist:List<TvShow>
        try {
            val response: Response<TvShowList> = tvShowRemoteDatasource.getTvshows()
            val body: TvShowList? = response.body()
            if(body !=null){
                tvshowlist = body.results
            }
        }catch(exception: Exception){

        }
        return tvshowlist;
    }

    suspend fun getTvShowsFromDB(): List<TvShow>{
        lateinit var tvShowList:List<TvShow>
        try {
            tvShowList = tvShowLocalDatasource.getTvshowsFromDB()
        }catch(exception: Exception){

        }

        if(tvShowList.size > 0){
            return tvShowList
        }else{
            tvShowList = getTvShowsFromApi()
            tvShowLocalDatasource.saveTvshowsToDB(tvShowList)
        }
        return tvShowList;
    }

    suspend fun getTvShowsFromCache(): List<TvShow>{
        lateinit var tvShowList:List<TvShow>
        try {
            tvShowList = tvShowCacheDatasource.getTvshowsFrmCache()
        }catch(exception: Exception){

        }

        if(tvShowList.size > 0){
            return tvShowList;
        }else{
            tvShowList = getTvShowsFromDB()
            tvShowCacheDatasource.saveTvshowsToCache(tvShowList)
        }
        return tvShowList
    }
}