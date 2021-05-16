package com.erbe.libkotlinalgo.trie10.final

infix fun String.example(function: () -> Unit) {
    println("---Example of $this---")
    function()
    println()
}