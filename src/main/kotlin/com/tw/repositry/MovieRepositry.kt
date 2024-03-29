package com.tw.repositry

import com.tw.domain.Movie
import io.micronaut.configuration.hibernate.jpa.scope.CurrentSession
import io.micronaut.spring.tx.annotation.Transactional
import javax.inject.Singleton
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext

@Singleton
open class MovieRepositry(@PersistenceContext private val manager: EntityManager) {

    @Transactional(readOnly = true)
    open fun findById(imdbId: String):Movie? = manager.find(Movie::class.java, imdbId)

    @Transactional(readOnly = true)
    open fun findAll() = manager.createQuery("from Movie", Movie::class.java).resultList

    @Transactional
    open fun addMovie(movie: Movie): Movie {
        manager.persist(movie)
        return movie
    }
}