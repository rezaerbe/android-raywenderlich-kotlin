package com.erbe.libkotlinalgo.heapsort17.challenge.challenges

/*
  Challenge 3
  The current example of heap sort sorts the elements in **ascending** order. How would you sort in **descending** order?
 */

val descending = Comparator { first: Int, second: Int ->
    when {
        first < second -> 1
        first > second -> -1
        else -> 0
    }
}