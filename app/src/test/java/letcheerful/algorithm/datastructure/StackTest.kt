package letcheerful.algorithm.datastructure

import org.junit.Assert
import org.junit.Test
import java.util.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class StackTest {

    class Stack {

        val array = Array<Int>(100) { it }
        var pointer = 0

        fun push(value: Int) {
            array[pointer] = value
            pointer++
        }

        fun pop(): Int? {
            return if(pointer > 0) {
                array[pointer]
                pointer--
            } else {
                null
            }
        }

    }

    @Test
    fun pushAndPop() {
        val stack = Stack<Int>()

        stack.push(1)

        Assert.assertEquals(1, stack.pop())
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
