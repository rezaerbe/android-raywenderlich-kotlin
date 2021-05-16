package com.erbe.kotlinapprenticelib.class11

fun main() {

    // Mini-exercise

    val john = Person(firstName = "Johnny", lastName = "Appleseed")

    var homeOwner = john

    homeOwner.lastName = "Smith"
    println(john.fullName)      // > John Smith
    println(homeOwner.fullName) // > John Smith

    // Mini-exercise

    fun memberOf(person: Person, group: Array<Person>): Boolean {
        return group.contains(person)
    }

    val groupWithJohn = arrayOf(
        Person("A", "B"),
        Person("C", "D"),
        john,
        Person("E", "F"),
        Person("G", "H")
    )

    val groupWithoutJohn = arrayOf(
        Person("A", "B"),
        Person("C", "D"),
        Person("E", "F"),
        Person("G", "H"),
        Person("I", "J")
    )

    println(memberOf(john, groupWithJohn)) // > true
    println(memberOf(john, groupWithoutJohn)) // > false

    // Mini-exercise

    val jane = Student(firstName = "Jane", lastName = "Appleseed")
    val history = Grade(letter = "B", points = 9.0, credits = 3.0)
    var math = Grade(letter = "A", points = 16.0, credits = 4.0)

    jane.recordGrade(history)
    jane.recordGrade(math)

    println(jane.gpa)
}