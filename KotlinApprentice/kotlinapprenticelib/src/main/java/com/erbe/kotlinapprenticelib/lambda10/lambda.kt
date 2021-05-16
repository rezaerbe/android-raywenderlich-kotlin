package com.erbe.kotlinapprenticelib.lambda10

fun main() {

    // Lambda basics

    var multiplyLambda: (Int, Int) -> Int

    multiplyLambda = { a: Int, b: Int ->
        Int
        a * b
    }

    val lambdaResult = multiplyLambda(4, 2) // 8

    //// Shorthand syntax

    multiplyLambda = { a, b ->
        a * b
    }

    //// it keyword

    var doubleLambda = { a: Int ->
        2 * a
    }

    doubleLambda = { 2 * it }

    val square: (Int) -> Int = { it * it }

    // lambdas as arguments

    fun operateOnNumbers(a: Int, b: Int, operation: (Int, Int) -> Int): Int {
        val result = operation(a, b)
        println(result)
        return result
    }

    val addLambda = { a: Int, b: Int ->
        a + b
    }
    operateOnNumbers(4, 2, operation = addLambda) // 6

    fun addFunction(a: Int, b: Int) = a + b

    operateOnNumbers(4, 2, operation = ::addFunction) // 6

    operateOnNumbers(4, 2, operation = { a: Int, b: Int ->
        a + b
    })

    operateOnNumbers(4, 2, { a, b ->
        a + b
    })

    operateOnNumbers(4, 2, operation = Int::plus)

    operateOnNumbers(4, 2) { a, b ->
        a + b
    }

    //// Lambdas with no return value

    var unitLambda: () -> Unit = {
        println("Kotlin Apprentice is awesome!")
    }
    unitLambda()

    unitLambda = { println("Kotlin Apprentice is awesome!") }
    unitLambda()

    var nothingLambda: () -> Nothing = { throw NullPointerException() }

    //// Capturing from the enclosing scope

    var counter = 0
    val incrementCounter = {
        counter += 1
    }
    println(counter) // > 0

    incrementCounter()
    incrementCounter()
    incrementCounter()
    incrementCounter()
    incrementCounter()
    println(counter) // > 5

    fun countingLambda(): () -> Int {
        var counter = 0
        val incrementCounter: () -> Int = {
            counter += 1
            counter
        }
        return incrementCounter
    }

    val counter1 = countingLambda()
    val counter2 = countingLambda()

    println(counter1()) // > 1
    println(counter2()) // > 1
    println(counter1()) // > 2
    println(counter1()) // > 3
    println(counter2()) // > 2

    // Custom sorting with lambdas

    val names = arrayOf("ZZZZZZ", "BB", "A", "CCCC", "EEEEE")
    names.sorted() // A, BB, CCCC, EEEEE, ZZZZZZ

    val namesByLength = names.sortedWith(compareBy {
        -it.length
    })
    println(namesByLength) // > [ZZZZZZ, EEEEE, CCCC, BB, A]

    // Iterating over collections with lambdas

    val values = listOf(1, 2, 3, 4, 5, 6)
    values.forEach {
        println("$it: ${it * it}")
    }
    // > 1: 1
    // > 2: 4
    // > 3: 9
    // > 4: 16
    // > 5: 25
    // > 6: 36

    var prices = listOf(1.5, 10.0, 4.99, 2.30, 8.19)

    val largePrices = prices.filter {
        it > 5.0
    }
    println(largePrices) // > [10.0, 8.19]

    val salePrices = prices.map {
        it * 0.9
    }
    println(salePrices) // > [1.35, 9.0, 4.4910000000000005, 2.07, 7.3709999999999996]

    val userInput = listOf("0", "11", "haha", "42")
    val numbers = userInput.map {
        it.toIntOrNull()
    }
    println(numbers) // > [0, 11, null, 42]

    val numbers2 = userInput.mapNotNull {
        it.toIntOrNull()
    }
    println(numbers2) // > [0, 11, 42]

    var sum = prices.fold(0.0) { a, b ->
        a + b
    }
    println(sum) // > 26.980000000000004

    sum = prices.reduce { a, b ->
        a + b
    }
    println(sum) // > 26.980000000000004

    val stock = mapOf(1.5 to 5, 10.0 to 2, 4.99 to 20, 2.30 to 5, 8.19 to 30)
    var stockSum = 0.0
    stock.forEach {
        stockSum += it.key * it.value
    }

    println(stockSum) // > 384.5
}