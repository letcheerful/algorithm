package letcheerful.algorithm.datastructure

import org.junit.Test
import java.util.*
import kotlin.collections.HashMap
import kotlin.collections.HashSet

class Graph<T> {

    val adjacencyMap = HashMap<T, HashSet<T>>()

    fun addEdge(srcVertex: T, destVertex: T)
    {
        adjacencyMap
            .computeIfAbsent(srcVertex) { HashSet() }
            .add(destVertex)

        adjacencyMap
            .computeIfAbsent(destVertex) { HashSet() }
            .add(srcVertex)
    }

//    fun bfs(vertex: T): List<T> {
//
//
//        HashMap(adjacencyMap.keys.map { it to false }.toMap())
//
//
//
//
//    }


    fun depthFirstSearch(vertex: T): String {
        // Mark all the vertices / nodes as not visited.
        val visitedMap = mutableMapOf<T, Boolean>().apply {
            adjacencyMap.keys.forEach { node -> put(node, false) }
        }

        // Create a stack for DFS. Both ArrayDeque and LinkedList implement Deque.
        val stack = Stack<T>()

        // Initial step -> add the startNode to the stack.
        stack.push(vertex)

        // Store the sequence in which nodes are visited, for return value.
        val traversalList = mutableListOf<T>()

        // Traverse the graph.
        while (stack.isNotEmpty()) {
            // Pop the node off the top of the stack.
            val currentNode = stack.pop()

            if (!visitedMap[currentNode]!!) {

                // Store this for the result.
                traversalList.add(currentNode)

                // Mark the current node visited and add to the traversal list.
                visitedMap[currentNode] = true

                // Add nodes in the adjacency map.
                adjacencyMap[currentNode]?.forEach { node ->
                    stack.push(node)
                }

            }

        }
        return traversalList.joinToString()
    }

    override fun toString(): String = StringBuffer().apply {
        for (key in adjacencyMap.keys) {
            append("$key -> ")
            append(adjacencyMap[key]?.joinToString(", ", "[", "]\n"))
        }
    }.toString()


    @Test
    fun testMakingGraph() {

        val graph = Graph<Int>()

        val edges = listOf(
            6 to 4, 4 to 5, 4 to 3, 5 to 2, 3 to 2, 5 to 1, 2 to 1
        )

        edges.forEach {
            graph.addEdge(it.first, it.second)
        }

        println(graph.toString())
        println(graph.depthFirstSearch(6))
    }
}