package com.erbe.libkotlinalgo.quicksort18.final

infix fun String.example(function: () -> Unit) {
    println("---Example of $this---")
    function()
    println()
}

fun <T> MutableList<T>.swapAt(first: Int, second: Int) {
    val aux = this[first]
    this[first] = this[second]
    this[second] = aux
}