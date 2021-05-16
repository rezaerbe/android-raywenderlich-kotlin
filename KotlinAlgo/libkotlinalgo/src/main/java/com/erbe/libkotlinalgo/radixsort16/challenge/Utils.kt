package com.erbe.libkotlinalgo.radixsort16.challenge

infix fun String.example(function: () -> Unit) {
    println("---Example of $this---")
    function()
    println()
}