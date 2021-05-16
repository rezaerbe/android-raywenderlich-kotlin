package com.erbe.kotlinapprenticelib.object12

data class Student2(val id: Int, val firstName: String, val lastName: String) {
    var fullName = "$lastName, $firstName"

    companion object {
        var counter = 0

        fun numberOfStudents() = counter
    }

    init {
        counter++
    }
}

fun main() {
    val carl = Student2(1, "Carl", "Sagan")
    val stephen = Student2(2, "Stephen", "Hawking")

    println(Student2.numberOfStudents())
}