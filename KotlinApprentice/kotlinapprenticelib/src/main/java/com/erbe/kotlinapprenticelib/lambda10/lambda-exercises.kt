package com.erbe.kotlinapprenticelib.lambda10

fun main() {

    // Mini-exercises

    //// 1

    val nameList = listOf("Anna", "Bob", "Craig", "Donna")

    var namesConcat = nameList.fold("") { a, b ->
        a + b
    }
    println(namesConcat) // > AnnaBobCraigDonna

    //// 2

    namesConcat = nameList.filter {
        it.length > 4
    }.fold("") { a, b ->
        a + b
    }
    println(namesConcat) // > CraigDonna

    //// 3

    val namesAndAges = mapOf("Anna" to 16, "Bob" to 35, "Craig" to 15, "Donna" to 28)

    val youngPeople = namesAndAges.filter {
        it.value < 18
    }
    println(youngPeople) // > {Anna=16, Craig=15}

    //// 4

    val youngPeopleNames = namesAndAges.filter {
        it.value < 18
    }.map {
        it.key
    }
    println(youngPeopleNames) // > [Anna, Craig]
}