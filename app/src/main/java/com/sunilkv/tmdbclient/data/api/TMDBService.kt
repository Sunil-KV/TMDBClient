package com.sunilkv.tmdbclient.data.api


import com.sunilkv.tmdbclient.data.model.tvshow.TvShowList
import com.sunilkv.tmdbclient.data.model.artist.ArtistList
import com.sunilkv.tmdbclient.data.model.movie.MovieList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TMDBService {
    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query(
            "api_key"
        ) apiKey:String
    ): Response<MovieList>

    @GET("tv/popular")
    suspend fun getPopularTvShows(
        @Query(
            "api_key"
        ) apiKey:String
    ): Response<TvShowList>

    @GET("person/popular")
    suspend fun getPopularArtist(
        @Query(
            "api_key"
        ) apiKey:String
    ): Response<ArtistList>
}