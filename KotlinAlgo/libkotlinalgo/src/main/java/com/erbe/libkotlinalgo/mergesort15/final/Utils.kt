package com.erbe.libkotlinalgo.mergesort15.final

infix fun String.example(function: () -> Unit) {
    println("---Example of $this---")
    function()
    println()
}