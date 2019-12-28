package letcheerful.algorithm.codility.StacksAndQueues

import org.junit.Assert
import org.junit.Test
import java.util.*

class Nesting {

    companion object {
        private val NESTED = 1
        private val NOT_NESTED = 0
    }

    fun solution(S: String): Int {
        val stack = Stack<Char>()
        S.filter {
            when (it) {
                '(', ')' -> true
                else -> false
            }
        }.forEach { char ->
            val previous = if (stack.empty()) null else stack.peek()

            if (previous == '(' && char == ')') stack.pop()
            else stack.push(char)
        }

        return if (stack.count() > 0) NOT_NESTED else NESTED
    }

    @Test
    fun test() {
        // S is empty;
        Assert.assertEquals(NESTED, solution(""))

        // S has the form "(U)" where U is a properly nested string;
        Assert.assertEquals(NESTED, solution("(U)"))

        // S has the form "VW" where V and W are properly nested strings.
        Assert.assertEquals(NESTED, solution("VW"))

        Assert.assertEquals(NESTED, solution("(()(())())"))
        Assert.assertEquals(NOT_NESTED, solution("())"))
    }
}