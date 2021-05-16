package com.erbe.kotlinapprenticelib.property13

import kotlin.math.roundToInt

class TV2(var height: Double, var width: Double) {
    var diagonal: Int
        get() {
            val result = Math.sqrt(height * height + width * width)
            return result.roundToInt()
        }
        set(value) {
            val ratioWidth = 16.0
            val ratioHeight = 9.0
            val ratioDiagonal = Math.sqrt(ratioWidth * ratioWidth + ratioHeight * ratioHeight)
            height = value * ratioHeight / ratioDiagonal
            width = height * ratioWidth / ratioHeight
        }
}

class Circle2(var radius: Double = 0.0) {
    val area: Double by lazy {
        kotlin.math.PI * radius * radius
    }
    val circumference: Double
        get() = kotlin.math.PI * radius * 2
}

fun main() {

    // Mini-exercise

    val tv = TV2(height = 32.0, width = 18.0)
    println(tv.diagonal)

    // Mini-exercise

    val circle = Circle2(5.0)
    println(circle.area) // 78.54...
}