package letcheerful.algorithm.grab

import org.junit.Assert
import org.junit.Test
import kotlin.math.abs
import kotlin.math.min

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class MinimumAdjacent {

    fun solution(A: IntArray): Int {
        val sorted = A.sorted()

        var minimumAdjacent = Int.MAX_VALUE
        var previous = sorted.first()

        for(index in 1..sorted.lastIndex) {
            val current = sorted[index]
            minimumAdjacent = min(current - previous, minimumAdjacent)
            previous = current

            if(minimumAdjacent == 0) break
        }

        return when{
            minimumAdjacent == Int.MAX_VALUE -> -2
            minimumAdjacent > 100000000 -> -1
            else -> minimumAdjacent
        }
    }


    @Test
    fun test() {
        Assert.assertEquals(-1, solution(intArrayOf(0, 100000001)))
        Assert.assertEquals(-2, solution(intArrayOf(1)))
        Assert.assertEquals(0, solution(intArrayOf(0, 3, 3, 7, 5, 3, 11, 1)))
    }
}
