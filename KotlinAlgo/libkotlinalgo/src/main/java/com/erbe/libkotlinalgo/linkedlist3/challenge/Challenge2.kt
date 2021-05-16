package com.erbe.libkotlinalgo.linkedlist3.challenge

/*:
 # Linked List Challenges
 ## Challenge 2:
 Create a function that returns the middle node of a linked list
 */

fun <T> LinkedList<T>.getMiddle(): Node<T>? {
    var slow = this.nodeAt(0)
    var fast = this.nodeAt(0)

    while (fast != null) {
        fast = fast.next
        if (fast != null) {
            fast = fast.next
            slow = slow?.next
        }
    }

    return slow
}