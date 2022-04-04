package com.sunilkv.tmdbclient.data.repository.artist

import com.sunilkv.tmdbclient.data.model.artist.Artist

interface ArtistLocalDataSource {
    suspend fun getArtistsFromDB() : List<Artist>
    suspend fun saveArtistsToDB(movies:List<Artist>)
    suspend fun clearAll()
}