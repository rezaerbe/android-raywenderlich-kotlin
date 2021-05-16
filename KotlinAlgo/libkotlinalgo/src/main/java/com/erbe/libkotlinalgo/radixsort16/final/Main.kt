package com.erbe.libkotlinalgo.radixsort16.final

import com.erbe.libkotlinalgo.radixsort16.final.radixsort.radixSort

fun main() {
    "radix sort" example {
        val list = arrayListOf(88, 410, 1772, 20)
        println("Original: $list")
        list.radixSort()
        println("Radix sorted: $list")
    }
}