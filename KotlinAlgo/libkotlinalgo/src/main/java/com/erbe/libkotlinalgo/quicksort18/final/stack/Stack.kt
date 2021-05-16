package com.erbe.libkotlinalgo.quicksort18.final

class Stack<T : Any>() {

    private val storage = arrayListOf<T>()

    constructor(elements: List<T>) : this() {
        storage.addAll(elements)
    }

    override fun toString() = buildString {
        appendln("----top----")
        storage.asReversed().forEach {
            appendln(it.toString())
        }
        appendln("-----------")
    }

    fun push(element: T) {
        storage.add(element)
    }

    fun pop(): T? {
        if (storage.size == 0) {
            return null
        }
        return storage.removeAt(storage.size - 1)
    }

    fun peek(): T? {
        return storage.lastOrNull()
    }

    val isEmpty: Boolean
        get() = storage.size == 0

}

fun <T : Any> stackOf(vararg elements: T): Stack<T> {
    return Stack(elements.asList())
}