package com.sunilkv.tmdbclient.data.repository.artist.datasourceimpl

import com.sunilkv.tmdbclient.data.model.artist.Artist
import com.sunilkv.tmdbclient.data.repository.artist.ArtistCacheDataSource

class ArtistCacheDatasourceImpl: ArtistCacheDataSource {
    private var artistlist = ArrayList<Artist>()
    override suspend fun getArtistsFrmCache(): List<Artist> {
        return artistlist
    }

    override suspend fun saveArtistsToCache(artists: List<Artist>) {
        artistlist.clear()
        artistlist = ArrayList(artists)
    }
}