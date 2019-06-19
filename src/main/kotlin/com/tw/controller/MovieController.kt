package com.tw.controller

import com.tw.domain.Movie
import com.tw.repositry.MovieRepositry
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import javax.inject.Inject

@Controller("/movie")
open class MovieController {

    @Inject
    lateinit var repository: MovieRepositry

    @Get
    fun findAll(): List<Movie> {
        return repository.findAll()
    }
}