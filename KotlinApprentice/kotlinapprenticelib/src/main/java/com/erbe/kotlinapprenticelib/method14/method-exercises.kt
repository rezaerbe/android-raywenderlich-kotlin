package com.erbe.kotlinapprenticelib.method14

class MyMath2 {
    companion object {
        fun triangle(number: Int): Int {
            return (1..number).fold(0) { a, b -> a + b }
        }
    }
}

fun main() {

    // Mini-exercise

    val months = arrayOf(
        "January", "February", "March",
        "April", "May", "June",
        "July", "August", "September",
        "October", "November", "December"
    )

    class SimpleDate5(var month: String) {
        val monthsUntilWinterBreak: Int
            get() = months.indexOf("December") - months.indexOf(month)
    }

    val date5 = SimpleDate5("August")
    println(date5.monthsUntilWinterBreak) // > 4

    // Mini-exercises

    println(MyMath2.triangle(2))
    println(MyMath2.triangle(3))
    println(MyMath2.triangle(4))
    println(MyMath2.triangle(5))
    println(MyMath2.triangle(6))
    println(MyMath2.triangle(7))
    println(MyMath2.triangle(8))
    println(MyMath2.triangle(9))
    println(MyMath2.triangle(10))
}