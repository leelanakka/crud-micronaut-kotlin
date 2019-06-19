package com.tw

import io.micronaut.runtime.Micronaut

object Application {

    @JvmStatic
    fun main(args: Array<String>) {
        Micronaut.build()
                .packages("com.tw")
                .mainClass(Application.javaClass)
                .start()
    }
}