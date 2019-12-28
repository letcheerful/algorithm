package letcheerful.algorithm.codility.StacksAndQueues

import org.junit.Assert
import org.junit.Test
import java.util.*

class Brackets {

    companion object {
        private val NESTED = 1
        private val NOT_NESTED = 0
    }

    fun solution(S: String): Int {
        val stack = Stack<Char>()
        S.filter {
            when (it) {
                '[', ']', '{', '}', '(', ')' -> true
                else -> false
            }
        }.forEach { char ->
            val previous = if (stack.empty()) null else stack.peek()

            when {
                previous == '[' && char == ']' -> {
                    stack.pop()
                }
                previous == '{' && char == '}' -> {
                    stack.pop()
                }
                previous == '(' && char == ')' -> {
                    stack.pop()
                }
                else -> stack.push(char)
            }
        }

        return if (stack.count() > 0) NOT_NESTED else NESTED
    }

    @Test
    fun testEmpty() {
        // S is empty;
        Assert.assertEquals(NESTED, solution(""))

        // S has the form "(U)" or "[U]" or "{U}" where U is a properly nested string;
        Assert.assertEquals(NESTED, solution("(U)"))
        Assert.assertEquals(NESTED, solution("[U]"))
        Assert.assertEquals(NESTED, solution("{U}"))

        // S has the form "VW" where V and W are properly nested strings.
        Assert.assertEquals(NESTED, solution("VW"))

        Assert.assertEquals(NESTED, solution("{[()()]}"))
        Assert.assertEquals(NOT_NESTED, solution("([)()]"))
    }
}