package com.erbe.libkotlinalgo.queue5.final.doublestack

/**
 * The Stack interface.
 */
interface Stack<Element> {

    /**
     * Push of an Element into the stack.Stack
     */
    fun push(element: Element)

    /**
     * Pops an element from the stack.Stack if any or returns null.
     */
    fun pop(): Element?

    val count: Int
        get

    fun peek(): Element?

    val isEmpty: Boolean
        get() = count == 0
}

/**
 * Simple stack.Stack implementation using an ArrayList
 */
class StackImpl<Element> : Stack<Element> {

    private val storage = arrayListOf<Element>()

    companion object {
        fun <Element> create(items: Iterable<Element>): Stack<Element> {
            val stack = StackImpl<Element>()
            for (item in items) {
                stack.push(item)
            }
            return stack
        }
    }

    override fun push(element: Element) {
        storage.add(element)
    }

    override fun pop(): Element? {
        if (isEmpty) {
            return null
        }
        return storage.removeAt(count - 1)
    }

    override fun peek(): Element? {
        return storage.lastOrNull()
    }

    override val count: Int
        get() = storage.size

    override fun toString() = buildString {
        appendln("----top----")
        storage.asReversed().forEach {
            appendln("$it")
        }
        appendln("-----------")
    }
}

fun <Element> stackOf(vararg elements: Element): Stack<Element> {
    return StackImpl.create(elements.asList())
}