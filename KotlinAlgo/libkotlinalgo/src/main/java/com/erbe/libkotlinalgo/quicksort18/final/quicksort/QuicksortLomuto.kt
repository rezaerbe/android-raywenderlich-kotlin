package com.erbe.libkotlinalgo.quicksort18.final.quicksort

import com.erbe.libkotlinalgo.quicksort18.final.swapAt

fun <T : Comparable<T>> MutableList<T>.quicksortLomuto(low: Int, high: Int) {
    if (low < high) {
        val pivot = this.partitionLomuto(low, high)
        this.quicksortLomuto(low, pivot - 1)
        this.quicksortLomuto(pivot + 1, high)
    }
}

fun <T : Comparable<T>> MutableList<T>.partitionLomuto(
    low: Int,
    high: Int
): Int {
    val pivot = this[high] // 1

    var i = low // 2
    for (j in low until high) { // 3
        if (this[j] <= pivot) { // 4
            this.swapAt(i, j) // 5
            i += 1
        }
        this.subList(low, i)
    }
    this.swapAt(i, high) // 6
    return i // 7
}