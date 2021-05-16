package com.erbe.kotlinapprenticelib.array8

fun main(args: Array<String>) {

    // Creating arrays

    val evenNumbers = arrayOf(2, 4, 6, 8)

    val fiveFives = Array(5, { 5 })
    println(fiveFives.joinToString())

    val vowels = arrayOf("a", "e", "i", "o", "u")

    //// Arrays of primitive types

    val oddNumbers = intArrayOf(1, 3, 5, 7)

    val otherOddNumbers = arrayOf(1, 3, 5, 7).toIntArray()

    val zeros = DoubleArray(4)
    println(zeros.joinToString())

    // Arguments to main

    for (arg in args) {
        println(arg)
    }

    args.forEach { arg ->
        println(arg)
    }

    // Creating lists

    val innerPlanets = listOf("Mercury", "Venus", "Earth", "Mars")

    val innerPlanetsArrayList: ArrayList<String> = arrayListOf("Mercury", "Venus", "Earth", "Mars")

    val subscribers: List<String> = listOf()

    // Mutable lists

    val outerPlanets = mutableListOf("Jupiter", "Saturn", "Uranus", "Neptune")

    val exoPlanets = mutableListOf<String>()

    // Accessing elements

    //// Using properties and methods

    val players = mutableListOf("Alice", "Bob", "Cindy", "Dan")
    println(players.isEmpty()) // > false

    if (players.size < 2) {
        println("We need at least two players!")
    } else {
        println("Let's start!")
    }
    // > Let's start!

    val arr = arrayOf<Int>()
//  println(arr.first()) // NoSuchElementException

    var currentPlayer = players.first()
    println(currentPlayer) // > Alice

    println(players.last()) // > Dan

    val minPlayer = players.min()
    minPlayer.let {
        println("$minPlayer will start") // > Alice will start
    }

    println(arrayOf(2, 3, 1).first())
    // > 2
    println(arrayOf(2, 3, 1).min())
    // > 1

    val maxPlayer = players.max()
    if (maxPlayer != null) {
        println("$maxPlayer is the MAX") // > Dan is the MAX
    }

    //// Using indexing

    val firstPlayer = players[0]
    println("First player is $firstPlayer")
    // > First player is Alice

    val secondPlayer = players.get(1)

    //val player = players[4] // > IndexOutOfBoundsException

    //// Using ranges to slice

    val upcomingPlayersSlice = players.slice(1..2).toMutableList()
    println(upcomingPlayersSlice.joinToString()) // > Bob, Cindy

    val upcomingPlayersArray = players.slice(1..2).toTypedArray()
    println(upcomingPlayersArray.joinToString()) // > Bob, Cindy

    //// Checking for an element

    fun isEliminated(player: String): Boolean {
        return player !in players
    }

    println(isEliminated("Bob")) // > false

    players.slice(1..3).contains("Alice") // false

    // Modifying lists

    //// Adding elements

    players.add("Eli")
    println(players.joinToString()) // > "Alice", "Bob", "Cindy", "Dan", "Eli"

    players += "Gina"
    println(players.joinToString()) // > "Alice", "Bob", "Cindy", "Dan", "Eli", "Gina"

    players.add(5, "Frank")
    println(players.joinToString()) // > "Alice", "Bob", "Cindy", "Dan", "Eli", "Frank", "Gina"

    var array = arrayOf(1, 2, 3)
    array += 4
    println(array.joinToString()) // > 1, 2, 3, 4

    //// Removing elements

    val wasPlayerRemoved = players.remove("Gina")
    println("It is $wasPlayerRemoved that Gina was removed") // > It is true that Gina was removed

    val removedPlayer = players.removeAt(2)
    println("$removedPlayer was removed") // > Cindy was removed


    //// Updating elements

    println(players.joinToString()) // > "Alice", "Bob", "Dan", "Eli", "Frank"
    players[4] = "Franklin"
    println(players.joinToString()) // > "Alice", "Bob", "Dan", "Eli", "Franklin"

    players[3] = "Anna"
    players.sort()
    println(players.joinToString()) // > "Alice", "Anna", Bob", "Dan", "Franklin"

    val arrayOfInts = arrayOf(1, 2, 3)
    arrayOfInts[0] = 4
    println(arrayOfInts.joinToString()) // > 4, 2, 3

    // Iterating through a list

    val scores = listOf(2, 2, 8, 6, 1)

    for (player in players) {
        println(player)
    }
    // > Alice
    // > Anna
    // > Bob
    // > Dan
    // > Franklin

    for ((index, player) in players.withIndex()) {
        println("${index + 1}. $player")
    }
    // > 1. Alice
    // > 2. Anna
    // > 3. Bob
    // > 4. Dan
    // > 5. Franklin

    fun sumOfElements(list: List<Int>): Int {
        var sum = 0
        for (number in list) {
            sum += number
        }
        return sum
    }

    println(sumOfElements(scores))  // > 19


    // Nullability and collection types

    var nullableList: List<Int>? = listOf(1, 2, 3, 4)

    nullableList = null

    var listOfNullables: List<Int?> = listOf(1, 2, null, 4)

    //listOfNullables = null // Error: Null can not be a value of a non-null type

    var nullableListOfNullables: List<Int?>? = listOf(1, 2, null, 4)

    nullableListOfNullables = null
}