package com.tw.controller

import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.test.annotation.MicronautTest
import org.junit.jupiter.api.Test
import javax.inject.Inject

@MicronautTest
internal class WelcomeControllerTest {

    @Inject
    @field:Client("/")
    lateinit var client: HttpClient

    @Test
    fun helloGreetingTest() {
        val result = client.toBlocking().retrieve("/hello")
        assert(result == "Welcome to new World !!! ")
    }
}