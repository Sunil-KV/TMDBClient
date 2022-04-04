package com.sunilkv.tmdbclient.data.repository.artist

import com.sunilkv.tmdbclient.data.model.artist.Artist
import com.sunilkv.tmdbclient.data.model.artist.ArtistList
import com.sunilkv.tmdbclient.domain.repository.ArtistRepository
import retrofit2.Response

class ArtistRepositoryImpl(
    private val artistLocalDataSource: ArtistLocalDataSource,
    private val artistCacheDataSource: ArtistCacheDataSource,
    private val artistRemoteDataSource: ArtistRemoteDataSource
): ArtistRepository {
    override suspend fun getArtists(): List<Artist>? {
        return getArtistsFromCache()
    }

    override suspend fun updateArtists(): List<Artist>? {
        val newListOfArtists: List<Artist> = getArtistsFromApi()
        artistLocalDataSource.clearAll()
        artistLocalDataSource.saveArtistsToDB(newListOfArtists)
        artistCacheDataSource.saveArtistsToCache(newListOfArtists)
        return newListOfArtists
    }

    suspend fun getArtistsFromApi(): List<Artist>{
        lateinit var artistlist:List<Artist>
        try {
            val response: Response<ArtistList> = artistRemoteDataSource.getArtists()
            val body: ArtistList? = response.body()
            if(body !=null){
                artistlist = body.artists
            }
        }catch(exception: Exception){

        }
        return artistlist;
    }

    suspend fun getArtistsFromDB(): List<Artist>{
        lateinit var artistlist:List<Artist>
        try {
            artistlist = artistLocalDataSource.getArtistsFromDB()
        }catch(exception: Exception){

        }

        if(artistlist.size > 0){
            return artistlist;
        }else{
            artistlist = getArtistsFromApi()
            artistLocalDataSource.saveArtistsToDB(artistlist)
        }
        return artistlist;
    }

    suspend fun getArtistsFromCache(): List<Artist>{
        lateinit var artistlist:List<Artist>
        try {
            artistlist = artistCacheDataSource.getArtistsFrmCache()
        }catch(exception: Exception){

        }

        if(artistlist.size > 0){
            return artistlist;
        }else{
            artistlist = getArtistsFromDB()
            artistCacheDataSource.saveArtistsToCache(artistlist)
        }
        return artistlist
    }
}