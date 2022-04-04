package com.sunilkv.tmdbclient.presentation.di.core

import android.content.Context
import androidx.room.Room
import com.sunilkv.tmdbclient.data.db.ArtistDao
import com.sunilkv.tmdbclient.data.db.MovieDao
import com.sunilkv.tmdbclient.data.db.TMDBDatabase
import com.sunilkv.tmdbclient.data.db.TvshowDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataBaseModule {

    @Singleton
    @Provides
    fun provideMovieDataBase(context:Context): TMDBDatabase{
        return Room.databaseBuilder(context, TMDBDatabase::class.java, "tmdbclient")
            .build()
    }

    @Singleton
    @Provides
    fun provideMovieDao(tmdbDatabase: TMDBDatabase): MovieDao{
        return tmdbDatabase.getMovieDao()
    }

    @Singleton
    @Provides
    fun provideArtistDao(tmdbDatabase: TMDBDatabase): ArtistDao{
        return tmdbDatabase.getArtistDao()
    }

    @Singleton
    @Provides
    fun provideTvshowDao(tmdbDatabase: TMDBDatabase): TvshowDao{
        return tmdbDatabase.getTvshowDao()
    }
}