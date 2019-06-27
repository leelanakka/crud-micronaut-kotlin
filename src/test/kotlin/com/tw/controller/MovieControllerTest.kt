package com.tw.controller

import com.tw.domain.MovieView
import io.micronaut.core.type.Argument
import io.micronaut.http.HttpRequest
import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.test.annotation.MicronautTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import javax.inject.Inject

@MicronautTest
class MovieControllerTest {
    @Inject
    @field:Client("/")
    private lateinit var client: HttpClient

    @Test
    fun `should return a movie by its id`() {
        val result: MovieView? = client.toBlocking().exchange(HttpRequest.GET<MovieView>("/movie/1234"), Argument.of(MovieView::class.java)).body()!!
        println(result)
        assertThat(result).isEqualTo(MovieView(id = "1234", title = "My First Movie"))

    }
}