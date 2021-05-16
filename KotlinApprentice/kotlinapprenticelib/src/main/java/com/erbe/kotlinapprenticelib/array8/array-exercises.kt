package com.erbe.kotlinapprenticelib.array8

fun main() {

    // Mini-exercise

    val players = mutableListOf("Alice", "Bob", "Cindy", "Dan")

    val indexOfBob = players.indexOf("Dan")
    println(indexOfBob)

    // Mini-exercise

    val scores = listOf(2, 2, 8, 6)

    for ((index, player) in players.withIndex()) {
        println("$player score is ${scores[index]}")
    }
}