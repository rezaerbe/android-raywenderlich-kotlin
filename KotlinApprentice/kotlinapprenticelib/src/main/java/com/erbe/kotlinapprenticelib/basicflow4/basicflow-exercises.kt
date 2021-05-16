package com.erbe.kotlinapprenticelib.basicflow4

import java.util.*

fun main() {

    // COMPARISON OPERATORS
    /*
    1. Create a constant called myAge and set it to your age.Then, create a constant called isTeenager that uses Boolean
    logic to determine if the age denotes someone in the age range of 13 to 19.
    */

    val myAge = 30
    val isTeenager = myAge >= 13 && myAge <= 19

    /*
    2. Create another constant called theirAge and set it to my age, which is 30. Then, create a constant called
    bothTeenagers that uses Boolean logic to determine if both you and I are teenagers.
    */

    val theirAge = 30
    val bothTeenagers = theirAge >= 13 && theirAge <= 19 && isTeenager

    /*
    3. Create a constant called reader and set it to your name as a string. Create a constant called author and set it to
    my name, Matt Galloway. Create a constant called authorIsReader that uses string equality to determine if reader and
    author are equal.
    */

    val reader = "Joe Bloggs"
    val author = "Matt Galloway"
    val authorIsReader = reader == author

    /*
    4. Create a constant called readerBeforeAuthor which uses string comparison to determine if reader comes before
    author.
    */

    val readerBeforeAuthor = reader < author

    // IF STATEMENTS
    /*
    1. Create a constant called myAge and initialize it with your age. Write an if statement to print out Teenager if
    your age is between 13 and 19, and Not a teenager if your age is not between 13 and 19.
    */

    // val myAge = 30
    if (myAge >= 13 && myAge <= 19) {
        println("Teenager")
    } else {
        println("Not a teenager")
    }

    /*
    2. Create a constant called answer and use a single line if-else statement to set it equal to the result you print out for the
    same cases in the above exercise. Then print out answer.
    */
    val answer = if (myAge >= 13 && myAge <= 19) "Teenager" else "Not a teenager"
    println(answer)


    // WHILE LOOPS
    /*
    1. Create a variable named counter and set it equal to 0. Create a while loop with the condition counter < 10 which
    prints out counter is X (where X is replaced with counter value) and then increments counter by 1.
    */
    var counter = 0
    while (counter < 10) {
        println("counter is $counter")
        counter += 1
    }

    /*
    2. Create a variable named counter and set it equal to 0. Create another variable named roll and set it equal to 0.
    Create a do-while loop. Inside the loop, set roll equal to Random().nextInt(6) which means to pick a
    random number between 0 and 5. Then increment counter by 1. Finally, print After X rolls, roll is Y where X is the
    value of counter and Y is the value of roll. Set the loop condition such that the loop finishes when the first 0 is
    rolled.
    */

    counter = 0
    var roll = 0
    do {
        roll = Random().nextInt(6)
        counter += 1
        println("After $counter roll(s), roll is $roll")
    } while (roll != 0)
}