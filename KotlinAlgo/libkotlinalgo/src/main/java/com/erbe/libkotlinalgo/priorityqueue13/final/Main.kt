package com.erbe.libkotlinalgo.priorityqueue13.final

fun main() {

    "max priority queue" example {
        val priorityQueue = ComparablePriorityQueueImpl<Int>()
        arrayListOf(1, 12, 3, 4, 1, 6, 8, 7).forEach {
            priorityQueue.enqueue(it)
        }
        while (!priorityQueue.isEmpty) {
            println(priorityQueue.dequeue())
        }
    }

    "min priority queue" example {
        val stringLengthComparator = object : Comparator<String> {
            override fun compare(o1: String?, o2: String?): Int {
                val length1 = o1?.length ?: -1
                val length2 = o2?.length ?: -1
                return length1 - length2
            }
        }
        val priorityQueue = ComparatorPriorityQueueImpl(stringLengthComparator)
        arrayListOf(
            "one",
            "two",
            "three",
            "forty",
            "five",
            "six",
            "seven",
            "eight",
            "nine"
        ).forEach {
            priorityQueue.enqueue(it)
        }
        while (!priorityQueue.isEmpty) {
            println(priorityQueue.dequeue())
        }
    }
}