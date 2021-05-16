package com.erbe.libkotlinalgo.heap12.challenge

fun main() {
    val array = arrayListOf(3, 10, 18, 5, 21, 100)
    val inverseComparator = object : Comparator<Int> { // 2
        override fun compare(o1: Int, o2: Int): Int = o2.compareTo(o1)
    }
    val minHeap = ComparatorHeapImpl.create(array, inverseComparator)
    val maxHeap = ComparableHeapImpl.create(array)
    println(minHeap.isMinHeap())
    println(maxHeap.isMinHeap())
}