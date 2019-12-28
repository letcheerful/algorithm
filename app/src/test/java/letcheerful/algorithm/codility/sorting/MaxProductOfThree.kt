package letcheerful.algorithm.codility.sorting

import org.junit.Assert
import org.junit.Test
import kotlin.math.max

class MaxProductOfThree {

    fun solution(A: IntArray): Int {
        val sorted = A.sortedDescending()

        val positiveMaxProduct = sorted[0] * sorted[1] * sorted[2]
        val mixedMaxProduct = sorted[0] * sorted[sorted.lastIndex - 1] * sorted[sorted.lastIndex - 2]

        return max(positiveMaxProduct, mixedMaxProduct)
    }

    @Test
    fun testSolution() {
        val input = intArrayOf(-3, 1, 2, -2, 5, 6)

        Assert.assertEquals(60, solution(input))
    }

}