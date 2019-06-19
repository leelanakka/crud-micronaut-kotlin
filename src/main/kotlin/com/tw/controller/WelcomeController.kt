package com.tw.controller

import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get

@Controller
class WelcomeController {

    @Get("/hello")
    fun hello() = "Welcome to new World !!! "

}