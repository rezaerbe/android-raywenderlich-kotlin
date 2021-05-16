package com.erbe.kotlinapprenticelib.advancedflow5

fun main() {

/*:
 ## Advanced Control Flow
 ### Challenge 1

 In the following for loop:

 ```
 var sum = 0
 for(i in 0..5) {
   sum += i
 }
 ```
 What will be the value of `sum`, and how many iterations will happen?
 */
    var sum = 0
    for (i in 0..5) {
        sum += i
    }
    println(sum)

// sum = 15, 6 iterations (0, 1, 2, 3, 4, 5)

/*:
 ### Challenge 2

 In the while loop below:
 ````
 var aLotOfAs = ""
 while aLotOfAs.count < 10 {
   aLotOfAs += "a"
 }
 ````
 How many instances of the character “a” will there be in `aLotOfAs`? Hint: `aLotOfAs.count` will tell you how many characters there are in the string `aLotOfAs`.
 */
    var aLotOfAs = ""
    while (aLotOfAs.length < 10) {
        aLotOfAs += "a"
    }
    println(aLotOfAs)
    println(aLotOfAs.length)
// aLotOfAs contains 10 instances of "a"

/*:
 ### Challenge 3
 Consider the following switch statement:

 ```
when {
    x == y && y == z -> println("x = y = z")
    z == 0 -> println("On the x/y plane")
    y == 0 -> println("On the x/z plane")
    x == 0 -> println("On the y/z plane")
    else -> println("Nothing special")
  }
 ```

 What will this code print when coordinates is each of the following?
 ```
 val (x, y, z) = Triple(1, 5, 0)
 val (x, y, z) = Triple(2, 2, 2)
 val (x, y, z) = Triple(3, 0, 1)
 val (x, y, z) = Triple(3, 2, 5)
 val (x, y, z) = Triple(0, 2, 4)
 ```
 */
    val (x, y, z) = Triple(1, 5, 0)
// "On the x/y plane"

//val (x, y, z) = Triple(2, 2, 2)
// "x = y = z"

//val (x, y, z) = Triple(3, 0, 1)
// "On the x/z plane"

//val (x, y, z) = Triple(3, 2, 5)
// "Nothing special"

// val (x, y, z) = Triple(0, 2, 4)
// "On the y/z plane"

    when {
        x == y && y == z -> println("x = y = z")
        z == 0 -> println("On the x/y plane")
        y == 0 -> println("On the x/z plane")
        x == 0 -> println("On the y/z plane")
        else -> println("Nothing special")
    }

/*:
 ### Challenge 4
 A closed range can never be empty. Why?
 */
// Ranges must always be increasing.  With a closed range the second number is always included in the range.

    val halfOpenRange = 100 until 100 // empty
    val closedRange = 100..100   // contains the number 100

    println(halfOpenRange.isEmpty())
    println(closedRange.isEmpty())

/*:
 ### Challenge 5
 Print a countdown from 10 to 0.  (Note: do not use the downTo method)
 */
    for (i in 0..10) {
        print(10 - i)
    }

/*:
 ### Challenge 6

 Print 0.0, 0.1, 0.2, 0.3, 0.4, 0.5, 0.6, 0.7, 0.8, 0.9, 1.0.
 */
    var value = 0.0

    repeat(10) {
        println(value)
        value += 0.1
    }

    // Alternate solution
    for (counter in 0..10) {
        println(counter.toDouble() * 0.1)
    }
}