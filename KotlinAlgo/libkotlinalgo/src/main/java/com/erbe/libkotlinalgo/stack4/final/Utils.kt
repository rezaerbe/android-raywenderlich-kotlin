package com.erbe.libkotlinalgo.stack4.final

infix fun String.example(function: () -> Unit) {
    println("---Example of $this---")
    function()
    println()
}