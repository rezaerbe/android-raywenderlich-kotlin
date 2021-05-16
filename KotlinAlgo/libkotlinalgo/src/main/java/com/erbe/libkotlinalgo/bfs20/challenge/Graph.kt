package com.erbe.libkotlinalgo.bfs20.challenge

interface Graph<T> {

    val allVertices: ArrayList<Vertex<T>>

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

    fun numberOfPaths(source: Vertex<T>, destination: Vertex<T>): Int {
        val numberOfPaths = Ref(0) // 1
        val visited: ArrayList<Vertex<T>> = arrayListOf() // 2
        paths(source, destination, visited, numberOfPaths) // 3
        return numberOfPaths.value
    }

    fun paths(
        source: Vertex<T>,
        destination: Vertex<T>,
        visited: ArrayList<Vertex<T>>,
        pathCount: Ref<Int>
    ) {
        visited.add(source) // 1
        if (source == destination) { // 2
            pathCount.value += 1
        } else {
            val neighbors = edges(source) // 3
            neighbors.forEach { edge ->
                // 4
                if (!visited.contains(edge.destination)) {
                    paths(edge.destination, destination, visited, pathCount)
                }
            }
        }
        // 5
        visited.remove(source)
    }

    fun breadthFirstSearch(source: Vertex<T>): ArrayList<Vertex<T>> {
        val queue = QueueStack<Vertex<T>>()
        val enqueued = ArrayList<Vertex<T>>()
        val visited = ArrayList<Vertex<T>>()

        queue.enqueue(source)
        enqueued.add(source)

        while (true) {
            val vertex = queue.dequeue() ?: break

            visited.add(vertex)

            val neighborEdges = edges(vertex)
            neighborEdges.forEach {
                if (!enqueued.contains(it.destination)) {
                    queue.enqueue(it.destination)
                    enqueued.add(it.destination)
                }
            }
        }

        return visited
    }

    fun bfs(source: Vertex<T>): ArrayList<Vertex<T>> {
        val queue = QueueStack<Vertex<T>>()
        val enqueued = arrayListOf<Vertex<T>>()
        val visited = arrayListOf<Vertex<T>>()

        queue.enqueue(source)
        enqueued.add(source)

        bfs(queue, enqueued, visited)

        return visited
    }

    private fun bfs(
        queue: QueueStack<Vertex<T>>,
        enqueued: ArrayList<Vertex<T>>,
        visited: ArrayList<Vertex<T>>
    ) {
        val vertex = queue.dequeue() ?: return

        visited.add(vertex)

        val neighborEdges = edges(vertex)
        neighborEdges.forEach {
            if (!enqueued.contains(it.destination)) {
                queue.enqueue(it.destination)
                enqueued.add(it.destination)
            }
        }

        bfs(queue, enqueued, visited)
    }

    fun isDisconnected(): Boolean {
        val firstVertex = allVertices.firstOrNull() ?: return false

        val visited = breadthFirstSearch(firstVertex)
        allVertices.forEach {
            if (!visited.contains(it)) return true
        }

        return false
    }

}

enum class EdgeType {
    DIRECTED,
    UNDIRECTED
}