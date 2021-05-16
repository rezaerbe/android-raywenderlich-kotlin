package com.erbe.libkotlinalgo.queue5.final.ringbuffer

import com.erbe.libkotlinalgo.queue5.final.base.Queue

class RingBufferQueue<T>(size: Int) : Queue<T> {

    private val ringBuffer: RingBuffer<T> = RingBuffer(size)

    override val count: Int
        get() = ringBuffer.count

    override fun peek(): T? = ringBuffer.first

    override fun enqueue(element: T): Boolean =
        ringBuffer.write(element)

    override fun dequeue(): T? =
        if (ringBuffer.isEmpty) null else ringBuffer.read()

    override fun toString(): String = ringBuffer.toString()
}