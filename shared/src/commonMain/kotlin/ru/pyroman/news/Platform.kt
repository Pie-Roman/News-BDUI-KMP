package ru.pyroman.news

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform