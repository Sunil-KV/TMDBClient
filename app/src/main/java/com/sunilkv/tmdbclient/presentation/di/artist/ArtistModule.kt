package com.sunilkv.tmdbclient.presentation.di.artist

import com.sunilkv.tmdbclient.domain.usecases.GetArtistsUsecase
import com.sunilkv.tmdbclient.domain.usecases.UpdateArtistUsecase
import com.sunilkv.tmdbclient.presentation.artist.ArtistViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class ArtistModule {

    @ArtistScope
    @Provides
    fun provideArtistViewModelFactory(
        getArtistsUsecase: GetArtistsUsecase,
        updateArtistUsecase: UpdateArtistUsecase
    ): ArtistViewModelFactory{
        return ArtistViewModelFactory(getArtistsUsecase, updateArtistUsecase)
    }
}