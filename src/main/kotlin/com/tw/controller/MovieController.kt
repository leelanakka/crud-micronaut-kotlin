package com.tw.controller

import com.tw.domain.Movie
import com.tw.domain.MovieView
import com.tw.service.MovieService
import com.tw.service.NoMovieFoundException
import io.micronaut.http.HttpResponse
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.*

@Controller("/movie")
open class MovieController(private val movieService: MovieService) {


    @Get
    fun findAll(): List<Movie> {
        return this.movieService.findAll()
    }

    @Post("/")
    fun addMovie(@Body movie: Movie): Movie {
        return this.movieService.addMovie(movie)
    }

    @Get("/{id}")
    @Produces(value = [MediaType.APPLICATION_JSON])
    fun findById(id: Int): MovieView {
        return this.movieService.findById(id.toString()).toMovieView()
    }

    @Error(exception = NoMovieFoundException::class)
    fun handleNoStoryFound(): HttpResponse<String> {
        return HttpResponse.notFound()
    }
}