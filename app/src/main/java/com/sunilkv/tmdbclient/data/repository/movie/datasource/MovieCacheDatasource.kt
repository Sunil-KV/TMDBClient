package com.sunilkv.tmdbclient.data.repository.movie.datasource

import com.sunilkv.tmdbclient.data.model.movie.Movie

interface MovieCacheDatasource {
    suspend fun getMoviesFrmCache() : List<Movie>
    suspend fun saveMoviesToCache(movies: List<Movie>)
}