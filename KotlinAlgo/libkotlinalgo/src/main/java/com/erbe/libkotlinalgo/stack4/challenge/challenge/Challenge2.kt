package com.erbe.libkotlinalgo.stack4.challenge.challenge

import com.erbe.libkotlinalgo.stack4.challenge.stack.StackImpl

/*:
 # Stack Challenges
 ## Challenge 2:
    Check for balanced parentheses.
    Given a string, check if there are `(` and `)` characters,
    and return `true` if the parentheses in the string are balanced.
    For example:

    h((e))llo(world)() // balanced parentheses

    (hello world // unbalanced parentheses
 */


fun String.checkParentheses(): Boolean {
    val stack = StackImpl<Char>()

    for (character in this) {
        when (character) {
            '(' -> stack.push(character)
            ')' -> if (stack.isEmpty) {
                return false
            } else {
                stack.pop()
            }
        }
    }
    return stack.isEmpty
}