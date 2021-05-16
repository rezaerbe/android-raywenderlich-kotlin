package com.erbe.libkotlinalgo.mergesort15.challenge

import com.erbe.libkotlinalgo.mergesort15.challenge.mergesort.mergeSort

fun main() {

    "merge sort" example {
        val list = listOf(7, 2, 6, 3, 9)
        println("Original: $list")

        val result = list.mergeSort()
        println("Merge sorted: $result")
    }

    "merge iterables" example {
        val list1 = listOf(1, 2, 3, 4, 5, 6, 7, 8)
        val list2 = listOf(1, 3, 4, 5, 5, 6, 7, 7)

        val result = com.erbe.libkotlinalgo.mergesort15.challenge.challenges.merge(list1, list2)
        println("Merge sorted: $result")
    }
}