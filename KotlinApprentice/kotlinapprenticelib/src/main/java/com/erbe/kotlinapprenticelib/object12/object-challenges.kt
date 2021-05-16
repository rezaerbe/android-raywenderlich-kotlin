package com.erbe.kotlinapprenticelib.object12

/*

Challenge 1

Create a named object that lets you check whether a given `Int` value is above a threshold.
Name the object `Threshold` and add a method `isAboveThreshold(value: Int)`.

*/


object Threshold {
    const val threshold = 10

    fun isAboveThreshold(value: Int) = value > threshold
}


/*

Challenge 2

Create a version of the `Student` class that uses a factory method `loadStudent(studentMap: Map<String, String>)`
to create a student with a first and last name from a map such as `mapOf("first_name" to "Neils", "last_name" to "Bohr")`.
Default to using "First" and "Last" should the map not contain a first name or last name.

*/

data class Student1 private constructor(val firstName: String, val lastName: String) {

    companion object {
        fun loadStudent(studentMap: Map<String, String>): Student1 {
            val firstName = studentMap["first_name"] ?: "First"
            val lastName = studentMap["last_name"] ?: "Last"
            return Student1(firstName, lastName)
        }
    }
}


/*

3. Create an anonymous object that implements the following interface:

interface ThresholdChecker {
  val lower: Int
  val upper: Int

  fun isLit(value: Int): Boolean
  fun tooQuiet(value: Int): Boolean
}

Use a lower value of 7 and an upper value of 10 in the anonymous object.

*/

interface ThresholdChecker {
    val lower: Int
    val upper: Int

    fun isLit(value: Int): Boolean
    fun tooQuiet(value: Int): Boolean
}

fun main() {

    // Challenge 1

    val theseGoToEleven = 11

    if (Threshold.isAboveThreshold(theseGoToEleven)) {
        println("Needed that extra push over the cliff.")
    } else {
        println("Not bad.")
    }

    // Challenge 2

    val studentMap = mapOf("first_name" to "Neils", "last_name" to "Bohr")
    val student = Student1.loadStudent(studentMap)
    println(student)

    // Challenge 3

    val thresholdChecker = object : ThresholdChecker {
        override val lower = 7
        override val upper = 10

        override fun isLit(value: Int) = value > upper
        override fun tooQuiet(value: Int) = value <= lower
    }

    if (thresholdChecker.isLit(11)) {
        println("That's what we do.")
    } else {
        println("Where can you go from there?")
    }


    if (thresholdChecker.tooQuiet(6)) {
        println("Crank it up!")
    } else {
        println("Rockin!")
    }
}