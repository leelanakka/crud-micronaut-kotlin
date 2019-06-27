package com.tw.service;


import com.tw.domain.Movie
import com.tw.repositry.MovieRepositry
import javax.inject.Singleton

@Singleton
open class MovieServiceImpl(private val movieRepositry: MovieRepositry) : MovieService {

    override fun findById(id: String): Movie {
        return movieRepositry.findById(id) ?: throw NoMovieFoundException(id)
    }

    override fun findAll(): List<Movie> {
        return movieRepositry.findAll()
    }

    override fun addMovie(movie: Movie): Movie {
        return movie.let {
            movieRepositry.addMovie(it)
        }
    }

}
