package com.erbe.kotlinapprenticelib.null7

fun main() {

    val myFavoriteSong: String? = null

//  val parsedInt = "10".toIntOrNull()
//  println(parsedInt) // > 10

    val parsedInt = "dog".toIntOrNull()
    println(parsedInt) // > null

    if (myFavoriteSong != null) {
        println("My favorite song is $myFavoriteSong.")
    } else {
        println("I don’t have a favorite song.")
    }
}