package com.erbe.libkotlinalgo.queue5.challenge

infix fun String.example(function: () -> Unit) {
    println("---Example of $this---")
    function()
    println()
}