package com.sunilkv.tmdbclient.presentation.di

import com.sunilkv.tmdbclient.presentation.di.artist.ArtistSubComponent
import com.sunilkv.tmdbclient.presentation.di.movie.MovieSubComponent
import com.sunilkv.tmdbclient.presentation.di.tvshow.TvshowSubComponent

interface Injector {
    fun createMovieSubcomponent(): MovieSubComponent
    fun createArtistSubcomponent(): ArtistSubComponent
    fun createTvshowSubcomponent(): TvshowSubComponent
}