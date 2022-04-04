package com.sunilkv.tmdbclient.data.repository.movie.datasourceImpl

import com.sunilkv.tmdbclient.data.model.movie.Movie
import com.sunilkv.tmdbclient.data.repository.movie.datasource.MovieCacheDatasource

class MovieCacheDatasourceImpl: MovieCacheDatasource {
    private var movielist = ArrayList<Movie>()
    override suspend fun getMoviesFrmCache(): List<Movie> {
        return movielist
    }

    override suspend fun saveMoviesToCache(movies: List<Movie>) {
        movielist.clear()
        movielist = ArrayList(movies)
    }
}