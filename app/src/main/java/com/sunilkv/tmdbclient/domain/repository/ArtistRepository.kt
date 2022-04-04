package com.sunilkv.tmdbclient.domain.repository

import com.sunilkv.tmdbclient.data.model.artist.Artist

interface ArtistRepository {
    suspend fun getArtists(): List<Artist>?
    suspend fun updateArtists(): List<Artist>?
}