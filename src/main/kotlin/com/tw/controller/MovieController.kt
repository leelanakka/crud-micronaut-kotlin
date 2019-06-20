package com.tw.controller

import com.tw.domain.Movie
import com.tw.repositry.MovieRepositry
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post
import javax.inject.Inject

@Controller("/movie")
open class MovieController {
    @Inject
    lateinit var repository: MovieRepositry

    @Get
    fun findAll(): List<Movie> {
        return repository.findAll()
    }

    @Post("/")
    fun addMovie(@Body movie: Movie): Movie {
        return repository.addMovie(movie)
    }

    @Get("/{id}")
    fun findById(id: Int): Movie? {
        println(id)
        return repository.findById(id.toString())
    }
}