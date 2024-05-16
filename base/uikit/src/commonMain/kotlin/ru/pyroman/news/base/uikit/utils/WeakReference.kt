package ru.pyroman.news.base.uikit.utils

expect class WeakReference<T : Any>(referred: T) {

    fun clear()

    fun get(): T?
}