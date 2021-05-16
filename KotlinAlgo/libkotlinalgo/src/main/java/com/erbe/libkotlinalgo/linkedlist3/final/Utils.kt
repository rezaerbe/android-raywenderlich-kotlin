package com.erbe.libkotlinalgo.linkedlist3.final

infix fun String.example(function: () -> Unit) {
    println("---Example of $this---")
    function()
    println()
}