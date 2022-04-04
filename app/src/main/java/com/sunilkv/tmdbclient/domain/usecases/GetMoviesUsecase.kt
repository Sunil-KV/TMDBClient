package com.sunilkv.tmdbclient.domain.usecases

import com.sunilkv.tmdbclient.data.model.movie.Movie
import com.sunilkv.tmdbclient.domain.repository.MovieRepository

class GetMoviesUsecase(private val movieRepository: MovieRepository) {
    suspend fun execute() : List<Movie>? = movieRepository.getMovies()
}