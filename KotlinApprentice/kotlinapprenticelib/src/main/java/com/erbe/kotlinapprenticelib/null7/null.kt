package com.erbe.kotlinapprenticelib.null7

fun main() {

    // Introducing null

    var name = "Joe Howard"
    var age = 30
    var occupation = "Software Developer & Author"

    // Introducing nullable types

    var errorCode: Int?
    errorCode = 100
    errorCode = null

    // Checking for null

    var result: Int? = 30
    println(result)

    //println(result + 1) // Operator call corresponds to a dot-qualified call 'result.plus(1)' which is not allowed on a nullable receiver 'result`.

    //// Not-null assertion operator

    var authorName: String? = "Joe Howard"
    var authorAge: Int? = 24

    val ageAfterBirthday = authorAge!! + 1
    println("After their next birthday, author will be $ageAfterBirthday")

//  authorAge = null
    println("After two birthdays, author will be ${authorAge!! + 2}")

    //// Null checks

    var nonNullableAuthor: String
    var nullableAuthor: String?

    if (authorName != null) {
        nonNullableAuthor = authorName
    } else {
        nullableAuthor = authorName
    }

    // Safe call

    var nameLength = authorName?.length
    println("Author's name has length $nameLength.")

    val nameLengthPlus5 = authorName?.length?.plus(5)
    println("Author's name length plus 5 is $nameLengthPlus5.")

    //// The let() function

    authorName?.let {
        nonNullableAuthor = authorName
    }

    authorName?.let {
        nameLength = authorName.length
    }

    // Elvis operator

    var nullableInt: Int? = 10
    var mustHaveResult = nullableInt ?: 0

    mustHaveResult = if (nullableInt != null) nullableInt else 0

    nullableInt = null
    mustHaveResult = nullableInt ?: 0
}