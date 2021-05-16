package com.erbe.libkotlinalgo.quicksort18.challenge.quicksort

import com.erbe.libkotlinalgo.quicksort18.challenge.swapAt

fun <T : Comparable<T>> MutableList<T>.quicksortHoare(low: Int, high: Int) {
    if (low < high) {
        val p = this.partitionHoare(low, high)
        this.quicksortHoare(low, p)
        this.quicksortHoare(p + 1, high)
    }
}

fun <T : Comparable<T>> MutableList<T>.partitionHoare(low: Int, high: Int): Int {
    val pivot = this[low] // 1
    var i = low - 1 // 2
    var j = high + 1

    while (true) {
        // 3
        do {
            j -= 1
        } while (this[j] > pivot)
        // 4
        do {
            i += 1
        } while (this[i] < pivot)

        if (i < j) { // 5
            this.swapAt(i, j)
        } else {
            return j // 6
        }
    }
}