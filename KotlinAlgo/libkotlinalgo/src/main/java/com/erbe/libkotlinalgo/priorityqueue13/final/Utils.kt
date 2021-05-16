package com.erbe.libkotlinalgo.priorityqueue13.final

infix fun String.example(function: () -> Unit) {
    println("---Example of $this---")
    function()
    println()
}