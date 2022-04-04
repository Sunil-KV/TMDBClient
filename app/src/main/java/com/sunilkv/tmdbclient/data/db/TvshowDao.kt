package com.sunilkv.tmdbclient.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.sunilkv.tmdbclient.data.model.artist.Artist
import com.sunilkv.tmdbclient.data.model.tvshow.TvShow

@Dao
interface TvshowDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveTvshows(tvshows:List<TvShow>)

    @Query("DELETE FROM popular_tvshow")
    suspend fun deleteTvshows()

    @Query("SELECT * FROM popular_tvshow")
    suspend fun getAllTvshows(): List<TvShow>
}