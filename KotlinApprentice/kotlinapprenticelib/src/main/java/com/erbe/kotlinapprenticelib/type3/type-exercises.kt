package com.erbe.kotlinapprenticelib.type3

fun main() {
    // TYPES
    val age1 = 42
    val age2 = 21
    val avg1 = (age1 + age2) / 2
    // Both operands of / are integers so the operation is an integer division and the result is truncated.
    val avg2 = (age1.toDouble() + age2.toDouble()) / 2
    // The first operand of / is now a Double. Because of this, 2 is inferred to be a Double as well and the result is correct.


    // STRINGS
    val firstName = "Joe"
    val lastName = "Howard"
    val fullName = firstName + " " + lastName
    val myDetails = "Hello, my name is $fullName."


    // PAIRS AND TRIPLES
    //val date = Triple(10, 17, 2015)
    //val (month, day, year) = date

    val date = Triple(10, 17, 2015)
    var (month, _, year) = date

    month = 5
    val updatedDate = Pair(month, year)
}