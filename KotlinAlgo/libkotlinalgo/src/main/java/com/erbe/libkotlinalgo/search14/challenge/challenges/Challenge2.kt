package com.erbe.libkotlinalgo.search14.challenge.challenges

import com.erbe.libkotlinalgo.search14.challenge.selectionsort.selectionSort

fun <T : Comparable<T>> MutableList<T>.biggestDuplicate(): T? {
    this.selectionSort()
    for (i in (1 until this.size).reversed()) {
        if (this[i] == this[i - 1]) {
            return this[i]
        }
    }
    return null
}