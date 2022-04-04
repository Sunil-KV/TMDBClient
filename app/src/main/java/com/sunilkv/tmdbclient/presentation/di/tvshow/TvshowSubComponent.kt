package com.sunilkv.tmdbclient.presentation.di.tvshow

import com.sunilkv.tmdbclient.presentation.artist.ArtistActivity
import com.sunilkv.tmdbclient.presentation.tvshow.TvshowActivity
import dagger.Subcomponent

@TvshowScope
@Subcomponent(modules = [TvshowModule::class])
interface TvshowSubComponent {
    fun inject(tvshowActivity: TvshowActivity)

    @Subcomponent.Factory
    interface Factory{
        fun create():TvshowSubComponent
    }
}