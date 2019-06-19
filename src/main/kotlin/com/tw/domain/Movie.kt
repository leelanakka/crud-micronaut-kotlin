package com.tw.domain

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "movies")
data class Movie(@Id var imdbId: String, var title: String) {
    constructor() : this("", "")
}