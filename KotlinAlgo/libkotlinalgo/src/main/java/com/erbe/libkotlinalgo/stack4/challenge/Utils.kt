package com.erbe.libkotlinalgo.stack4.challenge

infix fun String.example(function: () -> Unit) {
    println("---Example of $this---")
    function()
    println()
}