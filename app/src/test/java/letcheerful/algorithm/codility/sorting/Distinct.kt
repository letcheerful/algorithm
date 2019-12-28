package letcheerful.algorithm.codility.sorting

import org.junit.Assert
import org.junit.Test
import kotlin.math.max

class Distinct {

    fun solution(A: IntArray): Int {
        return A.distinct().size
    }

    fun solutionManual(A: IntArray): Int {

        val intMap = HashMap<Int, Boolean>()

        A.forEach {
            intMap[it] = true
        }

        return intMap.count()
    }

    @Test
    fun testSolution() {
        val input = intArrayOf(2, 1, 1, 2 , 3, 1)

        Assert.assertEquals(3, solutionManual(input))
    }

}