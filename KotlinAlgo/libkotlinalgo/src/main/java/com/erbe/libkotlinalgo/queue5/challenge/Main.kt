package com.erbe.libkotlinalgo.queue5.challenge

import com.erbe.libkotlinalgo.queue5.challenge.challenge.nextPlayer
import com.erbe.libkotlinalgo.queue5.challenge.challenge.reverse
import com.erbe.libkotlinalgo.queue5.challenge.doublestack.StackQueue
import com.erbe.libkotlinalgo.queue5.challenge.linkedlist.LinkedListQueue
import com.erbe.libkotlinalgo.queue5.challenge.list.ArrayListQueue
import com.erbe.libkotlinalgo.queue5.challenge.ringbuffer.RingBufferQueue

fun main() {
    "Queue with ArrayList" example {
        val queue = ArrayListQueue<String>().apply {
            enqueue("Ray")
            enqueue("Brian")
            enqueue("Eric")
        }
        println(queue)
        queue.dequeue()
        println(queue)
        println("Next up: ${queue.peek()}")
    }

    "Queue with Doubly Linked List" example {
        val queue = LinkedListQueue<String>().apply {
            enqueue("Ray")
            enqueue("Brian")
            enqueue("Eric")
        }
        println(queue)
        queue.dequeue()
        println(queue)
        println("Next up: ${queue.peek()}")
    }

    "Queue with Ring Buffer" example {
        val queue = RingBufferQueue<String>(10).apply {
            enqueue("Ray")
            enqueue("Brian")
            enqueue("Eric")
        }
        println(queue)
        queue.dequeue()
        println(queue)
        println("Next up: ${queue.peek()}")
    }

    "Queue with Double Stack" example {
        val queue = StackQueue<String>().apply {
            enqueue("Ray")
            enqueue("Brian")
            enqueue("Eric")
        }
        println(queue)
        queue.dequeue()
        println(queue)
        println("Next up: ${queue.peek()}")
    }

    "Boardgame manager with Queue" example {
        val queue = ArrayListQueue<String>().apply {
            enqueue("Vincent")
            enqueue("Remel")
            enqueue("Lukiih")
            enqueue("Allison")
        }
        println(queue)

        println("===== boardgame =======")
        queue.nextPlayer()
        println(queue)
        queue.nextPlayer()
        println(queue)
        queue.nextPlayer()
        println(queue)
        queue.nextPlayer()
        println(queue)
    }

    "Reverse queue" example {
        val queue = ArrayListQueue<String>().apply {
            enqueue("1")
            enqueue("21")
            enqueue("18")
            enqueue("42")
        }
        println("before: $queue")
        queue.reverse()
        println("after: $queue")
    }
}