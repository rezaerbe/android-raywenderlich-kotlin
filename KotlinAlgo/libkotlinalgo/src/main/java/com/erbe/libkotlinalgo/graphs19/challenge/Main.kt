package com.erbe.libkotlinalgo.graphs19.challenge

fun main() {
    val graph = AdjacencyList<String>()

    val vincent = graph.createVertex("vincent")
    val chesley = graph.createVertex("chesley")
    val ruiz = graph.createVertex("ruiz")
    val patrick = graph.createVertex("patrick")
    val ray = graph.createVertex("ray")
    val sun = graph.createVertex("sun")
    val cole = graph.createVertex("cole")
    val kerry = graph.createVertex("kerry")

    graph.add(EdgeType.UNDIRECTED, vincent, chesley, 0.0)
    graph.add(EdgeType.UNDIRECTED, vincent, ruiz, 0.0)
    graph.add(EdgeType.UNDIRECTED, vincent, patrick, 0.0)
    graph.add(EdgeType.UNDIRECTED, ruiz, ray, 0.0)
    graph.add(EdgeType.UNDIRECTED, ruiz, sun, 0.0)
    graph.add(EdgeType.UNDIRECTED, patrick, cole, 0.0)
    graph.add(EdgeType.UNDIRECTED, patrick, kerry, 0.0)
    graph.add(EdgeType.UNDIRECTED, cole, ruiz, 0.0)
    graph.add(EdgeType.UNDIRECTED, cole, vincent, 0.0)

    println(graph)
    println("Ruiz and Vincent both share a friend name Cole")
}