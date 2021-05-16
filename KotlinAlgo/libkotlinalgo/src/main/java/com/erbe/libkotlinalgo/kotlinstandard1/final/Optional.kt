package com.erbe.libkotlinalgo.kotlinstandard1.final

data class Car(val name: String, var doors: Int = 4) {
    fun drive() {}
}

fun main() {
    var car: Car? = null

    car = Car("Mercedes-Benz")

    car.drive()

    car?.drive()

    val immutableCar: Car = car ?: Car("Porche")

    car!!.drive()
}