package letcheerful.algorithm.codility.StacksAndQueues

import org.junit.Assert
import org.junit.Test
import java.util.*

class Fish {

    enum class Direction(val code: Int) {
        UPSTREAM(0),
        DOWNSTREAM(1),
        UNKOWN(2);

        companion object {
            fun codeOf(value: Int): Direction {
                return values().find { it.code == value } ?: UNKOWN
            }
        }
    }

    class Fish(val size: Int, val direction: Direction) {
        override fun toString(): String {
            return "Fish($size, $direction)"
        }
    }

    fun solution(A: IntArray, B: IntArray): Int {

        val sizes = A
        val directions = B.map { Direction.codeOf(it) }
        val stack = Stack<Fish>()
        val aliveFishes = ArrayList<Fish>()

        sizes
            .zip(directions) { size, direction ->
                Fish(size, direction)
            }
            .forEach {
                if(it.direction == Direction.DOWNSTREAM) stack.push(it)
                else {
                    while(stack.isNotEmpty()) {
                        val enemy = stack.peek()
                        if(enemy.size < it.size) {
                            stack.pop()
                        } else {
                            break
                        }
                    }
                    if(stack.isEmpty()) aliveFishes.add(it)
                }
            }

        return stack.count() + aliveFishes.count()
    }

    @Test
    fun testEmpty() {
        Assert.assertEquals(2, solution(intArrayOf(1, 2), intArrayOf(0, 1)))
        Assert.assertEquals(2, solution(intArrayOf(4, 3, 2, 1, 5), intArrayOf(0, 1, 0, 0, 0)))
        Assert.assertEquals(5, solution(intArrayOf(4, 3, 2, 1, 5), intArrayOf(1, 1, 1, 1, 1)))
    }
}