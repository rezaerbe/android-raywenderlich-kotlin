package com.erbe.libkotlinalgo.heapsort17.challenge.heapsort

import com.erbe.libkotlinalgo.heapsort17.challenge.swapAt

fun <T> Array<T>.heapSort(comparator: Comparator<T>) {
    this.heapfy(comparator)
    for (index in this.indices.reversed()) { // 1
        this.swapAt(0, index) // 2
        siftDown(0, index, comparator) // 3
    }
}

fun <T> Array<T>.heapfy(comparator: Comparator<T>) {

    if (this.isNotEmpty()) {
        (this.size / 2 downTo 0).forEach {
            this.siftDown(it, this.size, comparator)
        }
    }
}

fun <T> Array<T>.siftDown(index: Int, upTo: Int, comparator: Comparator<T>) {
    var parent = index // 1
    while (true) { // 2
        val left = leftChildIndex(parent) //3
        val right = rightChildIndex(parent)
        var candidate = parent // 4
        if (left < upTo &&
            comparator.compare(this[left], this[candidate]) > 0
        ) {
            candidate = left //5
        }
        if (right < upTo &&
            comparator.compare(this[right], this[candidate]) > 0
        ) {
            candidate = right // 6
        }
        if (candidate == parent) {
            return // 7
        }
        this.swapAt(parent, candidate)
        parent = candidate
    }
}

private fun leftChildIndex(index: Int) = (2 * index) + 1

private fun rightChildIndex(index: Int) = (2 * index) + 2