package com.sunilkv.tmdbclient.presentation.artist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sunilkv.tmdbclient.domain.usecases.GetArtistsUsecase
import com.sunilkv.tmdbclient.domain.usecases.UpdateArtistUsecase

class ArtistViewModelFactory(
    private val getArtistsUsecase: GetArtistsUsecase,
    private val updateArtistUsecase: UpdateArtistUsecase
): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ArtistViewModel(getArtistsUsecase, updateArtistUsecase) as T
    }
}