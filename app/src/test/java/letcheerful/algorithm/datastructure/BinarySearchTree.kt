package letcheerful.algorithm.datastructure

import org.junit.Assert
import org.junit.Test
import java.util.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class BinarySearchTree {

    class BinarySearchTree<T : Comparable<T>> {

        class Node<T>(
            var value: T? = null,
            var parent: Node<T>? = null,
            var left: Node<T>? = null,
            var right: Node<T>? = null
        ) {
            override fun toString(): String {
                return value.toString() + "\n" + left.toString() + right.toString()
            }
        }

        private var root: Node<T>? = null

        fun addNode(value: T, node: Node<T>): Boolean {
            return node.value?.let { parentValue ->
                when {
                    value < parentValue -> {
                        node.left
                            ?.run { addNode(value, this) }
                            ?: run {
                                node.left = Node(value)
                                node.left?.parent = node
                            }
                        true
                    }
                    value > parentValue -> {
                        node.right
                            ?.run { addNode(value, this) }
                            ?: run {
                                node.right = Node(value)
                                node.right?.parent = node
                            }
                        true
                    }
                    else -> false
                }
            } ?: false
        }

        fun add(value: T): Boolean {
            return root
                ?.run { return addNode(value, this) }
                ?: run { root = Node(value); return true }
        }

        fun delete(value: T): Boolean {

            val list = listOf(1, 2, 3)

            //1. 노드를 찾고
            val node = findNode(value, root)

            node?.also { node ->
                val parent = node.parent
                val left = node.left
                val right = node.right

                val childNode = when {
                    left != null && right != null -> {
                        if (left.value!! > right.value!!) left else right
                    }
                    left != null && right == null -> left
                    left == null && right != null -> right
                    else -> null
                }

                parent?.also {
                    when (node) {
                        it.left -> {
                            it.left = left
                        }
                        it.right -> {
                            it.right = left
                        }
                        else -> { /* Do nothing */ }
                    }
                }

                left?.left = right


            }
            return true
        }

        fun findNode(value: T, node: Node<T>?): Node<T>? {

            return node?.value?.let { nodeValue ->
                when {
                    value == nodeValue -> node
                    value > nodeValue -> {
                        node.left?.let { findNode(value, it) }
                    }
                    value < nodeValue -> {
                        node.right?.let { findNode(value, it) }
                    }
                    else -> null
                }
            }
        }

        override fun toString(): String {
            return root.toString()
        }

    }

    @Test
    fun testMakeTree() {
        val input = intArrayOf(10, 2, 3, 4, 5, 1, 6, 7, 9, 8)
        val tree = BinarySearchTree<Int>()

        input.forEach {
            tree.add(it)
        }

        println(tree)

//        Assert.assertEquals(3, tree.find(3))
    }

    @Test
    fun push2AndPop() {
        val stack = Stack<Int>()

        stack.push(1)
        stack.push(2)

        Assert.assertEquals(2, stack.pop())
        Assert.assertEquals(1, stack.pop())
    }
}