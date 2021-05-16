package com.erbe.kotlinapprenticelib.map9

fun main() {

    // 1 - Which of the following are valid statements?

//  val map1: Map<Int to Int> = emptyMap()
//  val map2 = emptyMap()
    val map3: Map<Int, Int> = emptyMap()

    val map4 = mapOf("One" to 1, "Two" to 2, "Three" to 3)

//  map4[1]
    map4["One"]
//  map4["Zero"] = 0
//  map4[0] = "Zero"

    val map5 = mutableMapOf("NY" to "New York", "CA" to "California")

    map5["NY"]
    map5["WA"] = "Washington"
//  map5["CA"] = null

    // 2 - Given a map with two-letter state codes as keys, and the full state names as values, write a function that prints all the states with names longer than eight characters. For example, for the map mapOf("NY" to "New York", "CA" to "California"), the output would be California.

    fun longStateNames(map: Map<String, String>) {
        for ((twoLetter, fullName) in map) {
            if (fullName.length > 8) {
                println(fullName)
            }
        }
    }

    longStateNames(map5)

    // 3 - Write a function that combines two maps into one. If a certain key appears in both maps, ignore the pair from the first maps. This is the function’s signature:
    //  xxxxxxxxxx fun mergeMaps(map1: Map<String, String>, map2: Map<String, String>): Map<String, String>

    fun mergeMaps(map1: Map<String, String>, map2: Map<String, String>): Map<String, String> {
        val map3: MutableMap<String, String> = mutableMapOf()
        map3.putAll(map1)
        map3.putAll(map2)
        return map3
    }

    val firstMap = mapOf("1" to "2", "2" to "2")
    val secondMap = mapOf("1" to "1", "3" to "3")
    println(mergeMaps(firstMap, secondMap))

    // 4 Declare a function occurrencesOfCharacters that calculates which characters occur in a string, as well as how often each of these characters occur. Return the result as a map. This is the function signature:
    // fun occurrencesOfCharacters(text: String): Map<Char, Int>
    // Hint: String is a collection of characters that you can iterate over with a for statement.
    // Bonus: To make your code shorter, maps have a special function that lets you add a default value if it is not found in the map. For example, map.getOrDefault('a', defaultValue = 0) returns 0 for the character 'a' if it is not found, instead of simply returning null.

    fun occurrencesOfCharacters(text: String): Map<Char, Int> {
        val map = mutableMapOf<Char, Int>()
        for (c in text) {
            val count = map.getOrDefault(c, defaultValue = 0)
            map[c] = count + 1
        }
        return map
    }

    println(occurrencesOfCharacters("I'm your huckleberry."))

    // 5 - Write a function that returns true if all of the values of a map are unique.  Use a set to test uniqueness. This is the function signature:
    // fun isInvertible(map: Map<String, Int>): Boolean

    fun isInvertible(map: Map<String, Int>) = map.values.toSet().size == map.values.size

    val invertibleMap = mapOf("1" to 1, "2" to 2, "3" to 3)
    println(isInvertible(invertibleMap))

    val nonInvertibleMap = mapOf("1" to 3, "2" to 2, "3" to 3)
    println(isInvertible(nonInvertibleMap))

    // 6 Given the map:
    /*
  val nameTitleLookup: Map<String, String?>
      = mutableMapOf("Mary" to "Engineer", "Patrick" to "Intern", "Ray" to "Hacker")
    */
    // Set the value of the key "Patrick" to null and completely remove the key and value for "Ray".

    val nameTitleLookup: MutableMap<String, String?> =
        mutableMapOf("Mary" to "Engineer", "Patrick" to "Intern", "Ray" to "Hacker")

    nameTitleLookup["Patrick"] = null
    nameTitleLookup.remove("Ray")

    println(nameTitleLookup)
}