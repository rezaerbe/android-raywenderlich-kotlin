package com.erbe.libkotlinalgo.kotlinstandard1.final

fun main() {
    val a = 5
    val b = 12
    var max = -1

    if (a > b) {
        max = a
    } else {
        max = b
    }

    println(max) // prints 12


    val groupSize = 3
    when (groupSize) {
        1 -> println("Single")
        2 -> println("Pair")
        3 -> { // Note the block
            println("Trio")
        }
        else -> println("This is either nobody or a big crowd")
    }
}