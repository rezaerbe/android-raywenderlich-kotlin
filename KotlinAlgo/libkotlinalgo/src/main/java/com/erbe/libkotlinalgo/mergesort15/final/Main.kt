package com.erbe.libkotlinalgo.mergesort15.final

import com.erbe.libkotlinalgo.mergesort15.final.mergesort.mergeSort

fun main() {

    "merge sort" example {
        val list = listOf(7, 2, 6, 3, 9)
        println("Original: $list")
        val result = list.mergeSort()
        println("Merge sorted: $result")
    }
}