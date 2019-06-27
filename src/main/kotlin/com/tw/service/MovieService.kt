package com.tw.service

import com.tw.domain.Movie
import javax.inject.Singleton

@Singleton
interface MovieService {
    fun findAll(): List<Movie>

    fun addMovie(movie: Movie): Movie
    fun findById(id: String): Movie
}

class NoMovieFoundException(imdbId: String) : RuntimeException("No story found for $imdbId")