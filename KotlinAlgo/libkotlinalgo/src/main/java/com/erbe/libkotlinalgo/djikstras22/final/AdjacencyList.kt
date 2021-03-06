package com.erbe.libkotlinalgo.djikstras22.final

class AdjacencyList<T> : Graph<T>() {

    val adjacencies: HashMap<Vertex<T>, ArrayList<Edge<T>>> = HashMap()
    val vertices
        get() = ArrayList(adjacencies.keys)

    override fun createVertex(data: T): Vertex<T> {
        val vertex = Vertex(adjacencies.count(), data)
        adjacencies[vertex] = ArrayList()
        return vertex
    }

    override fun addDirectedEdge(source: Vertex<T>, destination: Vertex<T>, weight: Double?) {
        val edge = Edge(source, destination, weight)
        adjacencies[source]?.add(edge)
    }

    override fun edges(source: Vertex<T>) = adjacencies[source] ?: arrayListOf()

    override fun weight(source: Vertex<T>, destination: Vertex<T>): Double? {
        return edges(source).firstOrNull { it.destination == destination }?.weight
    }

    override fun toString(): String {
        var result = ""

        adjacencies.forEach { vertex, edges ->
            var edgeString = ""
            edges.forEachIndexed { index, edge ->
                if (index != edges.count() - 1) {
                    edgeString += "${edge.destination.data}, "
                } else {
                    edgeString += edge.destination.data
                }
            }
            result += "${vertex.data} ---> [ $edgeString ]\n"
        }

        return result
    }
}