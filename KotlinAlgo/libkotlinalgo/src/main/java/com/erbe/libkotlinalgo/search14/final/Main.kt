package com.erbe.libkotlinalgo.search14.final

import com.erbe.libkotlinalgo.search14.final.bubblesort.bubbleSort
import com.erbe.libkotlinalgo.search14.final.insertionsort.insertionSort
import com.erbe.libkotlinalgo.search14.final.selectionsort.selectionSort

fun main() {
    "bubble sort" example {
        val list = arrayListOf(9, 4, 10, 3)
        println("Original: $list")
        list.bubbleSort(true)
        println("Bubble sorted: $list")
    }
    "selection sort" example {
        val list = arrayListOf(9, 4, 10, 3)
        println("Original: $list")
        list.selectionSort(true)
        println("Bubble sorted: $list")
    }
    "insertion sort" example {
        val list = arrayListOf(9, 4, 10, 3)
        println("Original: $list")
        list.insertionSort(true)
        println("Bubble sorted: $list")
    }
}