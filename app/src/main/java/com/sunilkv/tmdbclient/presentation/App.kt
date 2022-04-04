package com.sunilkv.tmdbclient.presentation

import android.app.Application
import com.sunilkv.tmdbclient.BuildConfig
import com.sunilkv.tmdbclient.presentation.di.Injector
import com.sunilkv.tmdbclient.presentation.di.artist.ArtistSubComponent
import com.sunilkv.tmdbclient.presentation.di.core.*
import com.sunilkv.tmdbclient.presentation.di.movie.MovieSubComponent
import com.sunilkv.tmdbclient.presentation.di.tvshow.TvshowSubComponent

class App: Application(), Injector {
    private lateinit var appComponent:AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .netModule(NetModule(BuildConfig.BASE_URL))
            .remoteDataModule(RemoteDataModule(BuildConfig.API_KEY))
            .build()
    }

    override fun createMovieSubcomponent(): MovieSubComponent {
        return appComponent.movieSubComponent().create()
    }

    override fun createArtistSubcomponent(): ArtistSubComponent {
        return appComponent.artistSubComponent().create()
    }

    override fun createTvshowSubcomponent(): TvshowSubComponent {
        return appComponent.tvshowSubComponent().create()
    }
}