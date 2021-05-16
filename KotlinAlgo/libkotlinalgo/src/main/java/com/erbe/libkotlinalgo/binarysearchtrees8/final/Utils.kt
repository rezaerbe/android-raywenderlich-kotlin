package com.erbe.libkotlinalgo.binarysearchtrees8.final

infix fun String.example(function: () -> Unit) {
    println("---Example of $this---")
    function()
    println()
}