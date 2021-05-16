package com.erbe.libkotlinalgo.trie10.challenge

infix fun String.example(function: () -> Unit) {
    println("---Example of $this---")
    function()
    println()
}