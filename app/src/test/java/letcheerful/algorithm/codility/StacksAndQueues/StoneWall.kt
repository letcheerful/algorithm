package letcheerful.algorithm.codility.StacksAndQueues

import org.junit.Assert
import org.junit.Test
import java.util.*

class StoneWall {

    fun solution(H: IntArray): Int {

        val groundedH = intArrayOf(0) + H + intArrayOf(0)
        val stack = Stack<Int>()
        var numberOfBlock = 0

        groundedH.forEach {
            if (stack.isEmpty()) stack.push(it)
            else {
                while (stack.isNotEmpty() && stack.peek() > it) {
                    stack.pop(); numberOfBlock++
                }
                if (stack.isNotEmpty() && stack.peek() < it) stack.push(it)
            }

//            println("After = $stack")
        }
        return numberOfBlock
    }

    @Test
    fun test() {
        Assert.assertEquals(7, solution(intArrayOf(8, 8, 5, 7, 9, 8, 7, 4, 8)))
//        Assert.assertEquals(1, solution(intArrayOf(1)))
    }
}