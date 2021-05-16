package com.erbe.libkotlinalgo.search14.challenge

import com.erbe.libkotlinalgo.search14.challenge.bubblesort.bubbleSort
import com.erbe.libkotlinalgo.search14.challenge.challenges.biggestDuplicate
import com.erbe.libkotlinalgo.search14.challenge.challenges.rev
import com.erbe.libkotlinalgo.search14.challenge.challenges.rightAlign
import com.erbe.libkotlinalgo.search14.challenge.insertionsort.insertionSort
import com.erbe.libkotlinalgo.search14.challenge.selectionsort.selectionSort

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
    "align right" example {
        val list = mutableListOf(3, 4, 134, 3, 3, 5, 6, 3, 5, 6, 1, 0)
        println("Original: $list")
        val element = 3
        list.rightAlign(element)
        println("Right align element $element: $list")
    }
    "biggest duplicate" example {
        val list = mutableListOf(3, 4, 14, 23, 134, 5, 36, 31, 15, 6, 1, 0)
        println("Original: $list")
        val element = list.biggestDuplicate()
        println("Biggest duplicate element: $element")
    }

    "reverse" example {
        val list = mutableListOf(3, 4, 14, 0, 23, 134, 5, 36, 31, 15, 6, 1, 0)
        println("Original: $list")
        list.rev()
        println("Reverse: $list")
    }
}