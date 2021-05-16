package com.erbe.kotlinapprenticelib.property13

import kotlin.properties.Delegates

class IceCream {
    var name: String = ""
    val ingredients: ArrayList<String> by lazy {
        arrayListOf<String>()
    }
}

class Car2(val make: String, val color: String, val tank: FuelTank = FuelTank())

class FuelTank {
    var lowFuel = true
    var level: Double by Delegates.observable(0.0) { _, _, new ->
        lowFuel = new < 0.1
    }
}

fun main() {

/*

Challenge 1

Rewrite the IceCream class below to use default values and lazy initialization:

    class IceCream {
      val name: String
      val ingredients: ArrayList<String>
    }

1. Use a default value for the name property.
2. Lazily initialize the ingredients list.

*/

    val mintChocolateChip = IceCream()
    mintChocolateChip.name = "Min Chocolate Chip"
    mintChocolateChip.ingredients.add("mint")
    mintChocolateChip.ingredients.add("chocolate chips")

/*

Challenge 2

At the beginning of the chapter, you saw a Car class. Dive into the inner workings of the car and rewrite the FuelTank class below with delegated property observer functionality:

    class FuelTank {
      var level = 0.0 // decimal percentage between 0 and 1
    }

1. Add a lowFuel property of Boolean type to the class.
2. Flip the lowFuel Boolean when the level drops below 10%.
3. Ensure that when the tank fills back up, the lowFuel warning will turn off.
4. Add a FuelTank property to Car and fill the tank. Then drive around for awhile.

*/

    val camaro = Car2("Chevrolet", "Silver")

    // Fill the tank
    camaro.tank.level = 1.0
    println(camaro.tank.lowFuel)

    // Drive around for awhile
    camaro.tank.level = 0.05
    println(camaro.tank.lowFuel)
}