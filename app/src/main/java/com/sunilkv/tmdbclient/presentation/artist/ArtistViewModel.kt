package com.sunilkv.tmdbclient.presentation.artist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.sunilkv.tmdbclient.data.model.artist.Artist
import com.sunilkv.tmdbclient.domain.usecases.GetArtistsUsecase
import com.sunilkv.tmdbclient.domain.usecases.UpdateArtistUsecase

class ArtistViewModel(
    private val getArtistsUsecase: GetArtistsUsecase,
    private val updateArtistUsecase: UpdateArtistUsecase
): ViewModel() {

    fun getArtists() = liveData {
        var artistlist : List<Artist>? = getArtistsUsecase.execute()
        emit(artistlist)
    }

    fun updateArtists() = liveData {
        var updateartists: List<Artist>? = updateArtistUsecase.execute()
        emit(updateartists)
    }
}