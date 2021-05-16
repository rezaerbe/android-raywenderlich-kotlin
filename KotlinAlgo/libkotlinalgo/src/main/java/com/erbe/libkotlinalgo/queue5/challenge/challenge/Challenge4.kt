package com.erbe.libkotlinalgo.queue5.challenge.challenge

import com.erbe.libkotlinalgo.queue5.challenge.base.Queue
import com.erbe.libkotlinalgo.queue5.challenge.doublestack.StackImpl

/*:
 # Queue Challenges
 ## Challenge 4:
    Implement a method to reverse the contents of a queue.
    Hint: The `Stack` data structure has been included in the project.
 */

fun <T> Queue<T>.reverse() {
    val aux = StackImpl<T>()
    var next = this.dequeue()
    while (next != null) {
        aux.push(next)
        next = this.dequeue()
    }

    next = aux.pop()
    while (next != null) {
        this.enqueue(next)
        next = aux.pop()
    }
}