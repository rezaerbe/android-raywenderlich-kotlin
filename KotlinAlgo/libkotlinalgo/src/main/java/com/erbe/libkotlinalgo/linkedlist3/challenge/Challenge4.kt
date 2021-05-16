package com.erbe.libkotlinalgo.linkedlist3.challenge

/*:
 # Linked List Challenges
 ## Challenge 4:
 Create a function that takes two sorted linked lists and merges them into a single sorted linked list
 */

fun <T : Comparable<T>> LinkedList<T>.mergeSorted(
    otherList: LinkedList<T>
): LinkedList<T> {
    if (this.isEmpty()) return otherList
    if (otherList.isEmpty()) return this

    val result = LinkedList<T>()

    var left = nodeAt(0)
    var right = otherList.nodeAt(0)

    while (left != null && right != null) {
        if (left.value < right.value) {
            left = append(result, left)
        } else {
            right = append(result, right)
        }
    }

    while (left != null) {
        left = append(result, left)
    }

    while (right != null) {
        right = append(result, right)
    }

    return result
}

private fun <T : Comparable<T>> append(
    result: LinkedList<T>,
    node: Node<T>
): Node<T>? {
    result.append(node.value)
    return node.next
}