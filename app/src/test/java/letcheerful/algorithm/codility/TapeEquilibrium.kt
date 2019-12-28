package letcheerful.algorithm.codility

import org.junit.Assert
import org.junit.Test
import kotlin.math.abs
import kotlin.math.min

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class TapeEquilibrium {

    fun solution(A: IntArray): Int {
        val sum = A.sum()

        var rightSum = 0
        var leftSum = 0

        var minDiff = Int.MAX_VALUE

        for(index in 0 until A.lastIndex) {
            leftSum += A[index]
            rightSum = sum - leftSum

            val diff = abs(leftSum - rightSum)

            minDiff = min(minDiff, diff)
        }

        return minDiff
        // write your code in Kotlin
    }


    @Test
    fun test() {
        val input = intArrayOf(1, 1, 3)

        Assert.assertEquals(1, solution(input))
    }

}
