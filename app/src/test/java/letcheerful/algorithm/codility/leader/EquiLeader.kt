package letcheerful.algorithm.codility.leader

import org.junit.Assert
import org.junit.Test
import kotlin.math.max

class EquiLeader {

    fun solution(A: IntArray): Int {
        val leftMap = HashMap<Int, Int>()
        val rightMap = A.fold(HashMap<Int, Int>()) { numberMap, number ->
            numberMap.apply { compute(number) { _, oldValue -> (oldValue ?: 0) + 1 } }
        }
        var count = 0

        for (index in A.indices) {
            val number = A[index]

            leftMap.apply { compute(number) { _, oldValue -> (oldValue ?: 0) + 1 } }
            rightMap.apply {
                get(number)?.also { count ->
                    if(count == 1) remove(number)
                    else put(number, count - 1)
                }
            }

            val leftLeader = leftMap.maxBy { it.value }?.let {
                if(it.value > (index + 1) / 2) it.key
                else null
            }
            val rightLeader = rightMap.maxBy { it.value }?.let {
                if(it.value > (A.lastIndex - index) / 2) it.key
                else null
            }

            if(leftLeader != null && rightLeader != null && leftLeader == rightLeader) count++
        }

        return count
    }

    @Test
    fun test() {

        Assert.assertEquals(3, solution(intArrayOf(4, 4, 2, 5, 3, 4, 4, 4)))
        Assert.assertEquals(0, solution(intArrayOf(1)))
        Assert.assertEquals(2, solution(intArrayOf(4, 3, 4, 4, 4, 2)))
    }
}