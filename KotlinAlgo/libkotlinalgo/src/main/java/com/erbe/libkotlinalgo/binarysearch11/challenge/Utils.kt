package com.erbe.libkotlinalgo.binarysearch11.challenge

infix fun String.example(function: () -> Unit) {
    println("---Example of $this---")
    function()
    println()
}