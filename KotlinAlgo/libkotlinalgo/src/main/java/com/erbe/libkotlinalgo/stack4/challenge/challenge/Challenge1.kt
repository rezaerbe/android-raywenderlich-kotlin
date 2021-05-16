package com.erbe.libkotlinalgo.stack4.challenge.challenge

import com.erbe.libkotlinalgo.stack4.challenge.linkedlist.LinkedList
import com.erbe.libkotlinalgo.stack4.challenge.stack.StackImpl

/*:
 # Stack Challenges
 ## Challenge 1:
    Print a linked list in reverse without using recursion.
    Given a linked list, print the nodes in reverse order.
    You should not use recursion to solve this problem.
 */

fun <T> LinkedList<T>.printInReverse() {
    val stack = StackImpl<T>()

    for (node in this) {
        stack.push(node)
    }

    var node = stack.pop()
    while (node != null) {
        println(node)
        node = stack.pop()
    }
}