package com.erbe.libkotlinalgo.quicksort18.challenge.challenge

import com.erbe.libkotlinalgo.quicksort18.challenge.Stack
import com.erbe.libkotlinalgo.quicksort18.challenge.quicksort.partitionLomuto

fun <T : Comparable<T>> MutableList<T>.quicksortIterativeLomuto(low: Int, high: Int) {
    val stack = Stack<Int>() // 1
    stack.push(low) // 2
    stack.push(high)

    while (!stack.isEmpty) { // 3
        // 4
        val end = stack.pop() ?: continue
        val start = stack.pop() ?: continue
        val p = this.partitionLomuto(start, end) // 5
        if ((p - 1) > start) {    // 6
            stack.push(start)
            stack.push(p - 1)
        }
        if ((p + 1) < end) {    // 7
            stack.push(p + 1)
            stack.push(end)
        }
    }
}