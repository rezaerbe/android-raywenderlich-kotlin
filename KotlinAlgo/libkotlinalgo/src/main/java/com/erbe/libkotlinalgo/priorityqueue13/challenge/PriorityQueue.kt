package com.erbe.libkotlinalgo.priorityqueue13.challenge

import java.util.*

abstract class AbstractPriorityQueue<T> : Queue<T> {

    abstract val heap: Heap<T>
        get

    override val count: Int
        get() = heap.count

    override fun enqueue(element: T): Boolean {
        heap.insert(element)
        return true
    }

    override fun dequeue() = heap.remove()

    override fun peek() = heap.peek()
}

class ComparablePriorityQueueImpl<T : Comparable<T>> :
    AbstractPriorityQueue<T>() {

    override val heap = ComparableHeapImpl<T>()
}

class ComparatorPriorityQueueImpl<T>(
    private val comparator: Comparator<T>
) : AbstractPriorityQueue<T>() {

    override val heap = ComparatorHeapImpl(comparator)
}