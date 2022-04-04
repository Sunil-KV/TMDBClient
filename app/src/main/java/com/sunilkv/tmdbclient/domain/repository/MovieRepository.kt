package com.sunilkv.tmdbclient.domain.repository

import com.sunilkv.tmdbclient.data.model.movie.Movie

interface MovieRepository {

    suspend fun getMovies(): List<Movie>?
    suspend fun updateMovies(): List<Movie>?
}