package com.erbe.libkotlinalgo.heap12.final

fun main() {
    val array = arrayListOf(1, 12, 3, 4, 1, 6, 8, 7) // 1
    val inverseComparator = object : Comparator<Int> { // 2
        override fun compare(o1: Int, o2: Int): Int = o2.compareTo(o1)
    }
    val minHeap = ComparatorHeapImpl.create(array, inverseComparator) // 3
    while (!minHeap.isEmpty) { // 4
        println(minHeap.remove())
    }
}