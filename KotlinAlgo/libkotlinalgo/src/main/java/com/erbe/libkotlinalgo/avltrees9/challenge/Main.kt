package com.erbe.libkotlinalgo.avltrees9.challenge

import kotlin.math.pow

fun main() {
    "leaf node count" example {
        println(leafNodes(3))
    }

    "node count" example {
        println(nodes(3))
    }

    "using TraversableBinaryNode" example {
        val tree = AVLTree<Int>()
        (0..14).forEach {
            tree.insert(it)
        }
        println(tree)
        tree.root?.traverseInOrder { println(it) }
    }
}

// Challenge 1
fun leafNodes(height: Int): Int {
    return 2.0.pow(height).toInt()
}

// Challenge 2
fun nodes(height: Int): Int {
    return 2.0.pow(height + 1).toInt() - 1
}