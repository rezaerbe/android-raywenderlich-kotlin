package com.erbe.libkotlinalgo.avltrees9.final

infix fun String.example(function: () -> Unit) {
    println("---Example of $this---")
    function()
    println()
}