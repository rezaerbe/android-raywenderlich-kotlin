package com.erbe.libkotlinalgo.radixsort16.challenge

import com.erbe.libkotlinalgo.radixsort16.challenge.challenge.digit
import com.erbe.libkotlinalgo.radixsort16.challenge.challenge.digits
import com.erbe.libkotlinalgo.radixsort16.challenge.challenge.lexicographicalSort
import com.erbe.libkotlinalgo.radixsort16.challenge.radixsort.radixSort

fun main() {
    "radix sort" example {
        val list = arrayListOf(88, 410, 1772, 20)
        println("Original: $list")
        list.radixSort()
        println("Radix sorted: $list")
    }

    "digits" example {
        val kb = 1024
        println("$kb has ${1024.digits()} digits")
        println("and the 3rd digit is ${1024.digit(3)}")
    }

    "MSD radix sort" example {
        val list = (0..10).map { (Math.random() * 10000).toInt() }.toMutableList()
        println("Original: $list")
        list.lexicographicalSort()
        println("Radix sorted: $list")
    }
}