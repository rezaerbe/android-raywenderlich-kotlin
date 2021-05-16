package com.erbe.libkotlinalgo.graphs19.challenge

interface Graph<T> {

    fun createVertex(data: T): Vertex<T>

    fun addDirectedEdge(source: Vertex<T>, destination: Vertex<T>, weight: Double?)

    fun addUndirectedEdge(source: Vertex<T>, destination: Vertex<T>, weight: Double?) {
        addDirectedEdge(source, destination, weight)
        addDirectedEdge(destination, source, weight)
    }

    fun add(edge: EdgeType, source: Vertex<T>, destination: Vertex<T>, weight: Double?) {
        when (edge) {
            EdgeType.DIRECTED -> addDirectedEdge(source, destination, weight)
            EdgeType.UNDIRECTED -> addUndirectedEdge(source, destination, weight)
        }
    }

    fun edges(source: Vertex<T>): ArrayList<Edge<T>>

    fun weight(source: Vertex<T>, destination: Vertex<T>): Double?

    fun numberOfPaths(
        source: Vertex<T>,
        destination: Vertex<T>
    ): Int {
        val numberOfPaths = Ref(0) // 1
        val visited: MutableSet<Vertex<T>> = mutableSetOf() // 2
        paths(source, destination, visited, numberOfPaths) // 3
        return numberOfPaths.value
    }

    fun paths(
        source: Vertex<T>,
        destination: Vertex<T>,
        visited: MutableSet<Vertex<T>>,
        pathCount: Ref<Int>
    ) {
        visited.add(source) // 1
        if (source == destination) { // 2
            pathCount.value += 1
        } else {
            val neighbors = edges(source) // 3
            neighbors.forEach { edge ->
                // 4
                if (edge.destination !in visited) {
                    paths(edge.destination, destination, visited, pathCount)
                }
            }
        }
        // 5
        visited.remove(source)
    }

}

enum class EdgeType {
    DIRECTED,
    UNDIRECTED
}