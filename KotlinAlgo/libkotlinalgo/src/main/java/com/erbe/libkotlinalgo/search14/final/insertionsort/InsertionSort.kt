package com.erbe.libkotlinalgo.search14.final.insertionsort

import com.erbe.libkotlinalgo.search14.final.swapAt

fun <T : Comparable<T>> MutableList<T>.insertionSort(showPasses: Boolean = false) {
    if (this.size < 2) return
    // 1
    for (current in 1 until this.size) {
        // 2
        for (shifting in (1..current).reversed()) {
            // 3
            if (this[shifting] < this[shifting - 1]) {
                swapAt(shifting, shifting - 1)
            } else {
                break
            }
        }
        // 4
        if (showPasses) println(this)
    }
}