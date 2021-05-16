package com.erbe.libkotlinalgo.kotlinstandard1.final

fun main() {
    val places = listOf("Paris", "London", "Bucharest")

    val mutablePlaces = mutableListOf("Paris", "London", "Bucharest")

    mutablePlaces.add("Budapest")
    println(mutablePlaces) // prints [Paris, London, Bucharest, Budapest]
}