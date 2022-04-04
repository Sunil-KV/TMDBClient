package com.sunilkv.tmdbclient.presentation.di.core

import android.content.Context
import com.sunilkv.tmdbclient.presentation.di.artist.ArtistSubComponent
import com.sunilkv.tmdbclient.presentation.di.movie.MovieSubComponent
import com.sunilkv.tmdbclient.presentation.di.tvshow.TvshowSubComponent
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(subcomponents = [MovieSubComponent::class, ArtistSubComponent::class, TvshowSubComponent::class])
class AppModule(private val context: Context) {
    @Singleton
    @Provides
    fun provideApplicationContext(): Context{
        return context.applicationContext
    }
}