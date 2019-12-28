package letcheerful.algorithm.datastructure

import org.junit.Assert
import org.junit.Test

class LinkedList<T> {

    class LinkedNode<T>(val value: T) : Node<T>(value) {
        var next: LinkedNode<T>? = null
    }

    var first: LinkedNode<T>? = null
        private set
    var last: LinkedNode<T>? = null
        private set
    var size: Int = 0
        private set

    fun get(index: Int) : T? {
        var currentIndex = 0
        var node = first

        while(currentIndex < index) {
            node = node?.next
            currentIndex++
        }

        return node?.value
    }

    fun add(element: T) {
        when{
            first == null -> {
                first = LinkedNode(element)
                last = first
                size++
            }
            size == 1 -> {
                last = LinkedNode(element)
                first?.next = last
                size++
            }
            size > 1 -> {
                val previousLast = last
                val newNode = LinkedNode(element)
                last = newNode
                previousLast?.next = last
                size++
            }

        }
    }

    override fun toString(): String {
        var node = first

        return buildString {
            append("[")
            while (node != null) {
                append(node?.value)
                node = node?.next

                if(node != null) append(", ")
            }
            append("]")
        }
    }

    @Test
    fun testAddAndGet() {
        val linkedList = LinkedList<Int>()

        linkedList.add(0)
        linkedList.add(1)
        linkedList.add(2)

        println(linkedList)

        Assert.assertEquals(0, linkedList.get(0))
        Assert.assertEquals(1, linkedList.get(1))
        Assert.assertEquals(2, linkedList.get(2))
    }
}