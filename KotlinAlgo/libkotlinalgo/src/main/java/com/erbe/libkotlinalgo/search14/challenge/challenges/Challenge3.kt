package com.erbe.libkotlinalgo.search14.challenge.challenges

import com.erbe.libkotlinalgo.search14.challenge.swapAt

fun <T : Comparable<T>> MutableList<T>.rev() {

    var left = 0
    var right = this.size - 1

    while (left < right) {
        swapAt(left, right)
        left++
        right--
    }
}