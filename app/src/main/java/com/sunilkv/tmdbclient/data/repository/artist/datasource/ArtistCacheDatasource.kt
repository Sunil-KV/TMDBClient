package com.sunilkv.tmdbclient.data.repository.artist

import com.sunilkv.tmdbclient.data.model.artist.Artist

interface ArtistCacheDataSource {
    suspend fun getArtistsFrmCache() : List<Artist>
    suspend fun saveArtistsToCache(movies: List<Artist>)
}