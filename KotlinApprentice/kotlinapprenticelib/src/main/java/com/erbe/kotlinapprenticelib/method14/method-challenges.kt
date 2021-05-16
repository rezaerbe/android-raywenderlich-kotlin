package com.erbe.kotlinapprenticelib.method14

import kotlin.math.PI
import kotlin.math.sqrt

class Circle(var radius: Double = 0.0) {
    var area: Double
        get() {
            return PI * radius * radius
        }
        set(value) {
            radius = sqrt(value / PI)
        }

    fun grow(factor: Double) {
        area *= 3
    }
}

val months = arrayOf(
    "January", "February", "March",
    "April", "May", "June",
    "July", "August", "September",
    "October", "November", "December"
)

class SimpleDate(var month: String, var day: Int = 0) {

    val totalDaysInCurrentMonth: Int
        get() {
            return when (month) {
                "January", "March", "May", "July", "August", "October", "December" -> 31
                "April", "June", "September", "November" -> 30
                "February" -> 28 // Note: leap years aren't taken into account here.
                else -> 0
            }
        }

    fun advance() {
        // Check for the end of the month
        if (day == totalDaysInCurrentMonth) {
            // Check for the end of the year
            if (month == "December") {
                month = "January"
            } else {
                // Increment the month
                month = months[months.indexOf(month) + 1]
            }
            // Start over at the first day of the month
            day = 1
        } else {
            // It is not the end of the month, just increment the day
            day += 1
        }
    }
}

object MyMath1 {
    fun isEven(number: Int) = number % 2 == 0
    fun isOdd(number: Int) = number % 2 == 1
}

fun main() {

/*

Challenge 1

Given the Circle class below:

    import kotlin.math.PI

    class Circle(var radius: Double = 0.0) {
      val area: Double
        get() {
          return PI * radius * radius
        }
    }

Write a method that can change an instance’s area by a growth factor. For example if you call circle.grow(factor = 3), the area of the instance will triple.

 Hint: Make area a var and add a setter to it.
*/

    val circle = Circle(5.0)
    println(circle.area) // > 78.54
    circle.grow(factor = 3.0)
    println(circle.area) // > 235.62

/*

Challenge 2

Here is a naïve way of writing advance() for the SimpleDate class you saw earlier in the chapter:

    val months = arrayOf(
        "January", "February", "March",
        "April", "May", "June",
        "July", "August", "September",
        "October", "November", "December"
    )

    class SimpleDate(var month:String, var day: Int = 0) {
      fun advance() {
        day += 1
      }
    }

    var date = SimpleDate(month = "December", day = 31)
    date.advance()
    date.month // December; should be January!
    date.day // 32; should be 1!

What happens when the function should go from the end of one month to the start of the next? Rewrite advance() to account for advancing from December 31st to January 1st.

*/

    var date = SimpleDate(month = "December", day = 31)
    date.advance()
    println(date.month) // > December; should be January!
    println(date.day) // > 32; should be 1!

    var date2 = SimpleDate(month = "February", day = 28)
    date2.advance()
    println(date2.month) // > March
    println(date2.day) // > 1

/*

Challenge 3

Create a Kotlin object named MyMath with isEven() and isOdd() methods that return true if a number is even or odd respectively.

*/


    println(MyMath1.isEven(42))
    println(MyMath1.isOdd(42))

/*

Challenge 4

Add extension methods isEven() and isOdd() to Int.

Note: Generally, you want to be careful about what functionality you add to standard library types as it can cause confusion for readers.


*/


    fun Int.isEven() = this % 2 == 0
    fun Int.isOdd() = this % 2 == 1

    println(42.isEven())
    println(42.isOdd())

/*

Challenge 5

Add the extension method primeFactors() to Int. Since this is an expensive operation, this is best left as an actual method.

*/


    fun Int.primeFactors(): List<Int> {
        var remainingValue = this
        var testFactor = 2
        val primes = kotlin.collections.mutableListOf<Int>()

        while (testFactor * testFactor <= remainingValue) {
            if (remainingValue % testFactor == 0) {
                primes.add(testFactor)
                remainingValue /= testFactor
            } else {
                testFactor += 1
            }
        }

        if (remainingValue > 1) {
            primes.add(remainingValue)
        }

        return primes
    }

    println(81.primeFactors()) // > [3, 3, 3, 3]
}