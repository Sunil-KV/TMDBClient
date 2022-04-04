package com.sunilkv.tmdbclient.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.sunilkv.tmdbclient.data.db.ArtistDao
import com.sunilkv.tmdbclient.data.db.MovieDao
import com.sunilkv.tmdbclient.data.db.TvshowDao
import com.sunilkv.tmdbclient.data.model.artist.Artist
import com.sunilkv.tmdbclient.data.model.movie.Movie
import com.sunilkv.tmdbclient.data.model.tvshow.TvShow

@Database(entities = [Movie::class, Artist::class, TvShow::class ],
    version = 1,
    exportSchema = false)
abstract class TMDBDatabase : RoomDatabase(){
    abstract fun getMovieDao() : MovieDao
    abstract fun getArtistDao() : ArtistDao
    abstract fun getTvshowDao() : TvshowDao

}