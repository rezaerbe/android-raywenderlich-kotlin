package com.erbe.libkotlinalgo.search14.challenge.challenges

import com.erbe.libkotlinalgo.search14.challenge.swapAt

fun <T : Comparable<T>> MutableList<T>.rightAlign(element: T) {
    // 1
    if (this.size < 2) return
    // 2
    var searchIndex = this.size - 2
    while (searchIndex >= 0) {
        // 3
        if (this[searchIndex] == element) {
            // 4
            var moveIndex = searchIndex
            while (moveIndex < this.size - 1 &&
                this[moveIndex + 1] != element
            ) {
                swapAt(moveIndex, moveIndex + 1)
                moveIndex++
            }
        }
        // 5
        searchIndex--
    }
}