package com.sunilkv.tmdbclient.data.repository.artist

import com.sunilkv.tmdbclient.data.model.artist.ArtistList
import retrofit2.Response

interface ArtistRemoteDataSource {
    suspend fun getArtists(): Response<ArtistList>
}