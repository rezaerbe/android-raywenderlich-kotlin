package com.erbe.libkotlinalgo.queue5.final

infix fun String.example(function: () -> Unit) {
    println("---Example of $this---")
    function()
    println()
}