package com.erbe.kotlinapprenticelib.class11

class MovieList(val name: String, val movies: MutableList<String> = mutableListOf()) {

    fun print() {
        println("Movie List: $name")
        movies.forEach {
            println(it)
        }
    }
}

class User(val lists: MutableMap<String, MovieList> = mutableMapOf<String, MovieList>()) {

    fun addList(list: MovieList) {
        lists[list.name] = list
    }

    fun list(name: String): MovieList? = lists[name]
}


fun main() {

/*

Challenge 1: Movie lists

Imagine you’re writing a movie-viewing application in Kotlin. Users can create lists of movies and share those lists with other users.

Create a User class and a MovieList class that maintains lists for users.

- User: Has a method addList() which adds the given list to a mutable map of MovieList objects (using the name as a key), and list(): MovieList? which will return the MovieList for the provided name.
- MovieList: Contains a name and a mutable list of movie titles. A print method will print all the movies in the movie list.
- Create jane and john users and have them create and share lists. Have both jane and john modify the same list and call print from both users. Are all the changes reflected?

*/


    // Give John and Jane an "Action" list
    val jane = User()
    val john = User()
    val actionList = MovieList(name = "Action")

    jane.addList(actionList)
    john.addList(actionList)

    // Add Jane's favorites
    jane.lists["Action"]?.movies?.add("Rambo")
    jane.lists["Action"]?.movies?.add("Terminator")

    // Add John's favorites
    john.lists["Action"]?.movies?.add("Die Hard")

    // See John's list:
    john.lists["Action"]?.print()

    // See Jane's list:
    jane.lists["Action"]?.print()

/*

Challenge 2: T-Shirt store — data classes

Your challenge here is to build a set of objects to support a T-shirt store. Decide if each object should be a class or a data class, and go ahead and implement them all.

- TShirt: Represents a shirt style you can buy. Each TShirt has a size, color, price, and an optional image on the front.
- User: A registered user of the t-shirt store app. A user has a name, email, and a ShoppingCart (see below).
- Address: Represents a shipping address, containing the name, street, city, and zip code.
- ShoppingCart: Holds a current order, which is composed of a list of TShirts that the User wants to buy, as well as a method to calculate the total cost. Additionally, there is an Address that represents where the order will be shipped.

*/

    data class TShirt(val size: Int, val color: String, var price: Double, val image: String?)

    data class Address(var name: String, var street: String, var city: String, var zip: String)

    class ShoppingCart(var address: Address, val shirts: MutableList<TShirt> = mutableListOf()) {
        fun totalPrice(): Double {
            var totalPrice = 0.0
            shirts.forEach {
                totalPrice += it.price
            }
            return totalPrice
        }
    }

    class User(var name: String, var email: String, val shoppingCart: ShoppingCart)
}