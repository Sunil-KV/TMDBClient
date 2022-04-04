package com.sunilkv.tmdbclient.data.repository.artist.datasourceimpl

import com.sunilkv.tmdbclient.data.api.TMDBService
import com.sunilkv.tmdbclient.data.model.artist.ArtistList
import com.sunilkv.tmdbclient.data.repository.artist.ArtistRemoteDataSource
import retrofit2.Response

class ArtistRemoteDatasourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey:String
): ArtistRemoteDataSource {
    override suspend fun getArtists(): Response<ArtistList> = tmdbService.getPopularArtist(apiKey)
}