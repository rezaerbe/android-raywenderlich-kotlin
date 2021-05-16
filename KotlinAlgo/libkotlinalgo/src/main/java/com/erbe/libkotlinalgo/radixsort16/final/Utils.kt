package com.erbe.libkotlinalgo.radixsort16.final

infix fun String.example(function: () -> Unit) {
    println("---Example of $this---")
    function()
    println()
}