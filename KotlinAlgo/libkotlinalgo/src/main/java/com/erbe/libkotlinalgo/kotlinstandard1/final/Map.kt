package com.erbe.libkotlinalgo.kotlinstandard1.final

fun noSideEffectList(names: List<String>) {
    println(names)
}

fun sideEffectList(names: MutableList<String>) {
    names.add("Joker")
}

fun mutableVsImmutable() {
    val people = mutableListOf("Brian", "Stanley", "Ringo")
    noSideEffectList(people) // [Brian, Stanley, Ringo]
    sideEffectList(people)   // Adds a Joker to the list
    noSideEffectList(people) // [Brian, Stanley, Ringo, Joker]
}

fun main() {
    val scores = mutableMapOf("Eric" to 9, "Mark" to 12, "Wayne" to 1)

    scores["Andrew"] = 0
}