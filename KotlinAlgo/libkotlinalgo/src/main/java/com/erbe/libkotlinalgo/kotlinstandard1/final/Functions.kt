package com.erbe.libkotlinalgo.kotlinstandard1.final

fun max(a: Int, b: Int): Int {
    return if (a > b) a else b
}

fun printMax(c: Int, d: Int) {
    val maxValue = max(c, d)
    println(maxValue)
}