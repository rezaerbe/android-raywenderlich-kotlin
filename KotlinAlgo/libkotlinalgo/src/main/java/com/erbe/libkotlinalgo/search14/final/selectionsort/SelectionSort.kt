package com.erbe.libkotlinalgo.search14.final.selectionsort

import com.erbe.libkotlinalgo.search14.final.swapAt

fun <T : Comparable<T>> MutableList<T>.selectionSort(showPasses: Boolean = false) {

    if (this.size < 2) return
    // 1
    for (current in 0 until (this.size - 1)) {
        var lowest = current
        // 2
        for (other in (current + 1) until this.size) {
            if (this[lowest] > this[other]) {
                lowest = other
            }
        }
        // 3
        if (lowest != current) {
            swapAt(lowest, current)
        }
        // 4
        if (showPasses) println(this)
    }
}