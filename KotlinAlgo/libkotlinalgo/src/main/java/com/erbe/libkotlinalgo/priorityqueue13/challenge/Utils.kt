package com.erbe.libkotlinalgo.priorityqueue13.challenge

infix fun String.example(function: () -> Unit) {
    println("---Example of $this---")
    function()
    println()
}