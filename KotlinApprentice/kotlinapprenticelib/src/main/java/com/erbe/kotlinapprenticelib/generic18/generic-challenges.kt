package com.erbe.kotlinapprenticelib.generic18

fun <T> List<T>.toBulletedList1(): String {
    val separator = "\n - "
    return this.map { "$it" }.joinToString(separator, prefix = separator, postfix = "\n")
}

//fun List<Any>.toBulletedList1(): String {
//}


interface Checkable1 {
    fun checkIsOK(): Boolean
}

class Mover1<T : Checkable1>(
    thingsToMove: List<T>,
    val truckHeightInInches: Int = (12 * 12)
) {

    private var thingsLeftInOldPlace = mutableListOf<T>()
    private var thingsInTruck = mutableListOf<Any>()
    private var thingsInNewPlace = mutableListOf<T>()

    private var thingsWhichFailedCheck = mutableListOf<T>()

    init {
        thingsLeftInOldPlace.addAll(thingsToMove)
    }

    fun moveEverythingToTruck(startingContainer1: Container1<T>?) {
        var currentContainer1 = startingContainer1
        while (thingsLeftInOldPlace.count() > 0) {
            val item = thingsLeftInOldPlace.removeAt(0)

            if (item.checkIsOK()) {
                if (currentContainer1 != null) {
                    if (!currentContainer1.canAddAnotherItem()) {
                        moveContainer1ToTruck(currentContainer1)
                        currentContainer1 = currentContainer1.getAnother()
                    }

                    currentContainer1.addItem(item)
                    println("Packed your $item!")
                } else {
                    thingsInTruck.add(item)
                    println("Moved your $item to the truck!")
                }
            } else {
                thingsWhichFailedCheck.add(item)
                println("Could not move your $item to the truck :[")
            }
        }

        currentContainer1?.let { moveContainer1ToTruck(it) }
    }

    private fun moveContainer1ToTruck(Container1: Container1<T>) {
        thingsInTruck.add(Container1)
        println(
            "Moved a Container1 with your ${
                Container1.contents().toBulletedList1()
            } to the truck!"
        )
    }

    fun moveEverythingIntoNewPlace() {
//    val BreakableThing1s = thingsInTruck.filterIsInstance<BreakableThing1>()
//    break
//    val items = thingsInTruck.filterIsInstance<T>()

        val Container1s = thingsInTruck.filterIsInstance<Container1<T>>()
        for (Container1 in Container1s) {
            thingsInTruck.remove(Container1)
            while (Container1.canRemoveAnotherItem()) {
                val itemInContainer1 = Container1.removeItem()
                println("Unpacked your $itemInContainer1!")
                tryToMoveItemIntoNewPlace(itemInContainer1)
            }
        }

        while (thingsInTruck.count() > 0) {
            @Suppress("UNCHECKED_CAST")
            val item = thingsInTruck.removeAt(0) as? T

            if (item != null) {
                tryToMoveItemIntoNewPlace(item)
            } else {
                println("Something in the truck was not of the expected generic type: $item")
            }
        }
    }

    private fun tryToMoveItemIntoNewPlace(item: T) {
        if (item.checkIsOK()) {
            thingsInNewPlace.add(item)
            println("Moved your $item into your new place!")
        } else {
            thingsWhichFailedCheck.add(item)
            println("Could not move your $item into your new place :[")
        }
    }

    fun finishMove() {
        println("OK, we finished! We were able to move your:${thingsInNewPlace.toBulletedList1()}")
        if (thingsWhichFailedCheck.isNotEmpty()) {
            println("But we need to talk about your:${thingsWhichFailedCheck.toBulletedList1()}")
        }
    }

    fun fitsInTruck(itemHeight: Int): Boolean {
        return truckHeightInInches > itemHeight
    }
}

class CheapThing1(
    val name: String
) : Checkable1 {

    override fun toString(): String {
        return name
    }

    override fun checkIsOK(): Boolean = true
}

class BreakableThing1(
    val name: String,
    var isBroken: Boolean = false
) : Checkable1 {

    fun smash() {
        isBroken = true
    }

    override fun toString(): String {
        return name
    }

    override fun checkIsOK(): Boolean {
        return !isBroken
    }
}

class Vehicle(
    val brandName: String,
    val modelName: String,
    val heightInInches: Int
) : Checkable1 {

    var heightCheckFunction: ((Int) -> Boolean)? = null

    override fun toString(): String {
        return "$brandName $modelName"
    }

    override fun checkIsOK(): Boolean {
        heightCheckFunction?.let {
            return it.invoke(heightInInches)
        }

        throw RuntimeException("You must provide a height check function!")
    }
}

interface Container1<T> {
    fun canAddAnotherItem(): Boolean
    fun addItem(item: T)

    fun canRemoveAnotherItem(): Boolean
    fun removeItem(): T

    fun getAnother(): Container1<T>

    fun contents(): List<T>
}

class CardboardBox1 : Container1<BreakableThing1> {
    private var items = mutableListOf<BreakableThing1>()

    override fun contents(): List<BreakableThing1> {
        return items.toList()
    }

    override fun canAddAnotherItem(): Boolean {
        return items.count() < 2
    }

    override fun addItem(item: BreakableThing1) {
        items.add(item)
    }

    override fun canRemoveAnotherItem(): Boolean {
        return items.count() > 0
    }

    override fun removeItem(): BreakableThing1 {
        val lastItem = items.last()
        items.remove(lastItem)
        return lastItem
    }

    override fun getAnother(): Container1<BreakableThing1> {
        return CardboardBox1()
    }
}

class ShippingContainer1 : Container1<Vehicle> {
    var vehicle: Vehicle? = null

    override fun contents(): List<Vehicle> {
        var list = mutableListOf<Vehicle>()
        vehicle?.let { list.add(it) }
        return list
    }

    override fun canAddAnotherItem(): Boolean {
        return vehicle == null
    }

    override fun addItem(item: Vehicle) {
        this.vehicle = item
    }

    override fun canRemoveAnotherItem(): Boolean {
        return vehicle != null
    }

    override fun removeItem(): Vehicle {
        val itemToReturn = vehicle!!
        vehicle = null
        return itemToReturn
    }

    override fun getAnother(): Container1<Vehicle> {
        return ShippingContainer1()
    }
}

interface PersonWithName {
    val firstName: String
    val lastName: String
}

class Classmate(
    override val firstName: String,
    override val lastName: String
) : PersonWithName

class Relative(
    override val firstName: String,
    override val lastName: String,
    val relationship: String
) : PersonWithName {

    override fun toString(): String {
        return "$relationship: $firstName $lastName"
    }
}

fun <T : PersonWithName> List<T>.printNames() {
    forEach { println("${it.firstName} ${it.lastName}") }
}

fun main() {
    val names = listOf("Bob", "Carol", "Ted", "Alice")
    println("Names: ${names.toBulletedList1()}")
    val firstName = names.first()
    println(firstName)

//  val firstInt: Int = names.first()

    val things = mutableListOf<Any>(1, 2)
    things.add("Steve")
    println("Things: ${things.toBulletedList1()}")

    val map = mapOf(
        Pair("one", 1),
        Pair("two", "II"),
        Pair("three", 3.0f)
    )

//  val one = map.get(1)
//  val one = map[1]

    val valuesForKeysWithE = map.keys
        .filter { it.contains("e") }
        .map { "Value for $it: ${map[it]}" }

    println("Values for keys with E: ${valuesForKeysWithE.toBulletedList1()}")

    val classmates = listOf(
        Classmate("Ralph", "Wiggum"),
        Classmate("Janey", "Powell"),
        Classmate("Sherri", "Mackleberry"),
        Classmate("Terri", "Mackleberry")
    )

    println("Classmates:")
    classmates.printNames()

    val family = listOf(
        Relative("Homer", "Simpson", "Father"),
        Relative("Marge", "Simpson", "Mother"),
        Relative("Bart", "Simpson", "Brother"),
        Relative("Maggie", "Simpson", "Sister")
    )
    println("Family:")
    family.printNames()


    val CheapThing1s = listOf(
        CheapThing1("Cinder Block table"),
        CheapThing1("Box of old books"),
        CheapThing1("Ugly old couch")
    )
    val cheapMover1 = Mover1(CheapThing1s)

    cheapMover1.moveEverythingToTruck(null)
    cheapMover1.moveEverythingIntoNewPlace()
    cheapMover1.finishMove()

    val television = BreakableThing1("Flat-Screen Television")
    val BreakableThing1s = listOf(
        television,
        BreakableThing1("Mirror"),
        BreakableThing1("Guitar")
    )
    val expensiveMover1 = Mover1(BreakableThing1s)

    expensiveMover1.moveEverythingToTruck(CardboardBox1())

    television.smash()

    expensiveMover1.moveEverythingIntoNewPlace()
    expensiveMover1.finishMove()

    val vehicles = listOf(
        Vehicle("Yamaha", "Vino", 40),
        Vehicle("Toyota", "Corolla", 58),
        Vehicle("Freightliner", "Cascadia", 150)
    )

    val vehicleMover1 = Mover1(vehicles)

    vehicles.forEach { it.heightCheckFunction = vehicleMover1::fitsInTruck }

    vehicleMover1.moveEverythingToTruck(ShippingContainer1())

    vehicleMover1.moveEverythingIntoNewPlace()
    vehicleMover1.finishMove()

    var items = mutableListOf<Checkable1>()
    items.addAll(CheapThing1s)
    items.addAll(BreakableThing1s)
    items.addAll(vehicles)
    val everythingMover1 = Mover1(items, 200)
    vehicles.forEach { it.heightCheckFunction = everythingMover1::fitsInTruck }

    everythingMover1.moveEverythingToTruck(null)
    everythingMover1.moveEverythingIntoNewPlace()
    everythingMover1.finishMove()

    val ints = listOf(1, 2, 3)
    val numbers: List<Number> = ints
//  val moreInts: List<Int> = numbers

    val mutableInts = mutableListOf(1, 2, 3)
//  val mutableNumbers: MutableList<Number> = mutableInts

    fun compare(comparator: Comparable<Number>) {
        val int: Int = 1
        comparator.compareTo(int)
        val float: Float = 1.0f
        comparator.compareTo(float)

        val intComparable: Comparable<Int> = comparator
        intComparable.compareTo(int)
//    intComparable.compareTo(float)
    }
}