package com.sunilkv.tmdbclient.data.repository.movie

import com.sunilkv.tmdbclient.data.model.movie.Movie
import com.sunilkv.tmdbclient.data.model.movie.MovieList
import com.sunilkv.tmdbclient.data.repository.movie.datasource.MovieCacheDatasource
import com.sunilkv.tmdbclient.data.repository.movie.datasource.MovieLocalDatasource
import com.sunilkv.tmdbclient.data.repository.movie.datasource.MovieRemoteDatasource
import com.sunilkv.tmdbclient.domain.repository.MovieRepository
import retrofit2.Response

class MovieRepositoryImpl(
    private val movieLocalDatasource: MovieLocalDatasource,
    private val movieRemoteDatasource: MovieRemoteDatasource,
    private val movieCacheDatasource: MovieCacheDatasource
): MovieRepository {
    override suspend fun getMovies(): List<Movie>? {
        return getMoviesFromCache()
    }

    override suspend fun updateMovies(): List<Movie>? {
        val newListOfMovies: List<Movie> = getMoviesFromApi()
        movieLocalDatasource.clearAll()
        movieLocalDatasource.saveMoviesToDB(newListOfMovies)
        movieCacheDatasource.saveMoviesToCache(newListOfMovies)
        return newListOfMovies
    }

    suspend fun getMoviesFromApi(): List<Movie>{
        lateinit var movielist:List<Movie>
        try {
            val response: Response<MovieList> = movieRemoteDatasource.getMovies()
            val body: MovieList? = response.body()
            if(body !=null){
                movielist = body.movies
            }
        }catch(exception: Exception){

        }
        return movielist;
    }

    suspend fun getMoviesFromDB(): List<Movie>{
        lateinit var movielist:List<Movie>
        try {
            movielist = movieLocalDatasource.getMoviesFromDB()
        }catch(exception: Exception){

        }

        if(movielist.size > 0){
            return movielist;
        }else{
            movielist = getMoviesFromApi()
            movieLocalDatasource.saveMoviesToDB(movielist)
        }
        return movielist;
    }

    suspend fun getMoviesFromCache(): List<Movie>{
        lateinit var movielist:List<Movie>
        try {
            movielist = movieCacheDatasource.getMoviesFrmCache()
        }catch(exception: Exception){

        }

        if(movielist.size > 0){
            return movielist;
        }else{
            movielist = getMoviesFromDB()
            movieCacheDatasource.saveMoviesToCache(movielist)
        }
        return movielist;
    }
}