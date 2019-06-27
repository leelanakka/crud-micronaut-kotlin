package com.tw.domain

import io.micronaut.http.HttpResponse
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "movies")
data class Movie(@Id var imdbId: String, var title: String) {
    fun toMovieView(): MovieView {
        return MovieView(imdbId,title)
    }

    constructor() : this("", "")
}


data class MovieView(val id:String,val title: String)