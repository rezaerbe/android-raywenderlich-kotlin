package com.erbe.kotlinapprenticelib.interface17

interface Area {
    val area: Double
}

fun main() {

    class Square(val side: Double) : Area {
        override val area: Double
            get() = side * side
    }

    class Triangle(val base: Double, val height: Double) : Area {
        override val area: Double
            get() = 0.5 * base * height
    }

    class Circle(val radius: Double) : Area {
        override val area: Double
            get() = kotlin.math.PI * radius * radius
    }

    val square = Square(4.0)
    val triangle = Triangle(3.0, 5.0)
    val circle = Circle(2.0)
    val shapes = arrayOf(square, triangle, circle)
    println(shapes.map { it.area })
}