package com.erbe.libkotlinalgo.linkedlist3.challenge

/*:
 # Linked List Challenges
 ## Challenge 1:
 Create an extension function that prints out the elements of a Linked List in reverse order.
 */

fun <T> LinkedList<T>.printInReverse() {
    this.nodeAt(0)?.printInReverse()
}

fun <T> Node<T>.printInReverse() {
    this.next?.printInReverse()
    if (this.next != null) {
        print(" -> ")
    }
    print(this.value.toString())
}