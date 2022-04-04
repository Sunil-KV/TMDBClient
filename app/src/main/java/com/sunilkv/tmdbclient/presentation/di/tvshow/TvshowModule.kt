package com.sunilkv.tmdbclient.presentation.di.tvshow

import com.sunilkv.tmdbclient.domain.usecases.GetArtistsUsecase
import com.sunilkv.tmdbclient.domain.usecases.GetTvshowsUsecase
import com.sunilkv.tmdbclient.domain.usecases.UpdateArtistUsecase
import com.sunilkv.tmdbclient.domain.usecases.UpdateTvshowsUsecase
import com.sunilkv.tmdbclient.presentation.artist.ArtistViewModelFactory
import com.sunilkv.tmdbclient.presentation.tvshow.TvshowViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class TvshowModule {

    @TvshowScope
    @Provides
    fun provideTvshowViewModelFactory(
        getTvshowsUsecase: GetTvshowsUsecase,
        updateTvshowsUsecase: UpdateTvshowsUsecase
    ): TvshowViewModelFactory{
        return TvshowViewModelFactory(getTvshowsUsecase,
            updateTvshowsUsecase)
    }
}