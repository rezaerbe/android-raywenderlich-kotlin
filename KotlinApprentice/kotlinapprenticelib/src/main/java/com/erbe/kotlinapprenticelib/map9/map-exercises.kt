package com.erbe.kotlinapprenticelib.map9

fun main() {

    // Mini-exercise

    val bobData = mutableMapOf(
        "name" to "Bob",
        "profession" to "CardPlayer",
        "country" to "USA"
    )

    bobData.put("state", "CA")

    bobData["city"] = "San Francisco"

    fun printCityAndState(player: Map<String, String>) {
        println(player["city"])
        println(player["state"])
    }

    printCityAndState(bobData)
}