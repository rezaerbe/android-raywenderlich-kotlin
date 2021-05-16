package com.erbe.libkotlinalgo.heapsort17.final

import com.erbe.libkotlinalgo.heapsort17.final.heapsort.heapSort

fun main() {
    "Heap sort" example {
        val array = arrayOf(6, 12, 2, 26, 8, 18, 21, 9, 5)
        array.heapSort(ascending)
        print(array.joinToString())
    }
}