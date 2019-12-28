package letcheerful.algorithm.codility.sorting

import org.junit.Assert
import org.junit.Test

class Triangle {

    fun solution(A: IntArray): Int {
        val sorted = A.sorted()

        var first: Int?
        var second: Int?
        var third: Int?

        for (index in 0..sorted.lastIndex - 2) {
            first = sorted[index]; second = sorted[index + 1]; third = sorted[index + 2]

            val rule1 = (first + second - third) > 0
            val rule2 = (second + third - first) > 0
            val rule3 = (first + third - second) > 0

            if (rule1 && rule2 && rule3) return 1
        }
        return 0
    }

    @Test
    fun testSolution() {
        Assert.assertEquals(1, solution(intArrayOf(10, 2, 5, 1, 8, 20)))
        Assert.assertEquals(0, solution(intArrayOf(10, 50, 5, 1)))
    }

}