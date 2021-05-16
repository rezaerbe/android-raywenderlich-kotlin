package com.erbe.kotlinapprenticelib.function6

fun main() {
    fun printFullName(firstName: String, lastName: String) {
        println("$firstName $lastName")
    }
    printFullName("Joe", "Howard")

    printFullName(firstName = "Joe", lastName = "Howard")

    fun calculateFullName(firstName: String, lastName: String): String {
        return "$firstName $lastName"
    }

    val fullName = calculateFullName("Joe", "Howard")

    fun calculateFullNameWithLength(firstName: String, lastName: String): Pair<String, Int> {
        val fullName = "$firstName $lastName"
        return Pair(fullName, fullName.length)
    }

    val fullNameLength = calculateFullNameWithLength("Joe", "Howard").second
}