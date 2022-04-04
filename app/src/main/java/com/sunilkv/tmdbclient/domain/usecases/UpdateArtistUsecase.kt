package com.sunilkv.tmdbclient.domain.usecases

import com.sunilkv.tmdbclient.data.model.artist.Artist
import com.sunilkv.tmdbclient.domain.repository.ArtistRepository

class UpdateArtistUsecase (private val artistRepository: ArtistRepository){
    suspend fun execute() : List<Artist>? = artistRepository.updateArtists()
}