package com.erbe.libkotlinalgo.queue5.challenge.linkedlist

data class Node<T>(var value: T, var next: Node<T>? = null, var previous: Node<T>? = null) {
    override fun toString(): String {
        return if (next != null) {
            "$value -> ${next.toString()}"
        } else {
            "$value"
        }
    }
}