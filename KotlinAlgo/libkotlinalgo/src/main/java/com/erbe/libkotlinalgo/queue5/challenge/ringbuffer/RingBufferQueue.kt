package com.erbe.libkotlinalgo.queue5.challenge.ringbuffer

import com.erbe.libkotlinalgo.queue5.challenge.base.Queue

class RingBufferQueue<T>(size: Int) : Queue<T> {

    private val ringBuffer: RingBuffer<T> = RingBuffer(size)

    override val count: Int
        get() = ringBuffer.count

    override fun peek(): T? = ringBuffer.first

    override fun enqueue(element: T): Boolean {
        return ringBuffer.write(element)
    }

    override fun dequeue(): T? {
        return if (ringBuffer.isEmpty) null else ringBuffer.read()
    }

    override fun toString(): String {
        return ringBuffer.toString()
    }
}