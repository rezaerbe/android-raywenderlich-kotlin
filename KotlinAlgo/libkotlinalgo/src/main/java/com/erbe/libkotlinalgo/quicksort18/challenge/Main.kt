package com.erbe.libkotlinalgo.quicksort18.challenge

import com.erbe.libkotlinalgo.quicksort18.challenge.challenge.quicksortIterativeLomuto
import com.erbe.libkotlinalgo.quicksort18.challenge.quicksort.*

fun main() {

    "Naive quicksort" example {
        val list = arrayListOf(12, 0, 3, 9, 2, 18, 8, 27, 1, 5, 8, -1, 21)
        println("Original: $list")
        val sorted = list.quicksortNaive()
        println("Sorted: $sorted")
    }
    "Lomuto quicksort" example {
        val list = arrayListOf(12, 0, 3, 9, 2, 21, 18, 27, 1, 5, 8, -1, 8)
        println("Original: $list")
        list.quicksortLomuto(0, list.size - 1)
        println("Sorted: $list")
    }
    "Hoare quicksort" example {
        val list = arrayListOf(12, 0, 3, 9, 2, 21, 18, 27, 1, 5, 8, -1, 8)
        println("Original: $list")
        list.quicksortHoare(0, list.size - 1)
        println("Sorted: $list")
    }
    "Median of three quicksort" example {
        val list = arrayListOf(12, 0, 3, 9, 2, 21, 18, 27, 1, 5, 8, -1, 8)
        println("Original: $list")
        list.quickSortMedian(0, list.size - 1)
        println("Sorted: $list")
    }
    "Dutch flag quicksort" example {
        val list = arrayListOf(12, 0, 3, 9, 2, 21, 18, 27, 1, 5, 8, -1, 8)
        println("Original: $list")
        list.quicksortDutchFlag(0, list.size - 1)
        println("Sorted: $list")
    }
    "Iterative lomuto quicksort" example {
        val list = arrayListOf(12, 0, 3, 9, 2, 21, 18, 27, 1, 5, 8, -1, 8)
        println("Original: $list")
        list.quicksortIterativeLomuto(0, list.size - 1)
        println("Sorted: $list")
    }
}