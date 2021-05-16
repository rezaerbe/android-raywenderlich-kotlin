package com.erbe.libkotlinalgo.binarysearch11.final

infix fun String.example(function: () -> Unit) {
    println("---Example of $this---")
    function()
    println()
}