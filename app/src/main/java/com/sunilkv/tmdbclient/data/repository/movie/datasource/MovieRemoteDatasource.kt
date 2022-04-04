package com.sunilkv.tmdbclient.data.repository.movie.datasource

import com.sunilkv.tmdbclient.data.model.movie.Movie
import com.sunilkv.tmdbclient.data.model.movie.MovieList
import retrofit2.Response

interface MovieRemoteDatasource {
    suspend fun getMovies(): Response<MovieList>
}