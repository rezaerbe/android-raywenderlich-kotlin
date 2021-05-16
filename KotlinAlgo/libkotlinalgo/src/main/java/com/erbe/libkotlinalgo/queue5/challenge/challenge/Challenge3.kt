package com.erbe.libkotlinalgo.queue5.challenge.challenge

import com.erbe.libkotlinalgo.queue5.challenge.base.Queue

/*:
 # Queue Challenges
 ## Challenge 3:
    Create a Monopoly organizer that always tells you whose turn it is.
    A great option is to create an extension function for `Queue` that always returns the next player
 */

fun <T> Queue<T>.nextPlayer(): T? {
    val person = this.dequeue() ?: return null
    this.enqueue(person)
    return person
}