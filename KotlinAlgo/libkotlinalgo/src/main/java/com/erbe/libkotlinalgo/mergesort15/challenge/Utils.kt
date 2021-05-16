package com.erbe.libkotlinalgo.mergesort15.challenge

infix fun String.example(function: () -> Unit) {
    println("---Example of $this---")
    function()
    println()
}