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
class FrogRiverOne {

    fun solution(X: Int, A: IntArray): Int {
        val CANNOT_CROSS_RIVER = -1

        val pathMap = HashMap<Int, Boolean>()
        for (index in A.indices) {
            pathMap[A[index]] = true
            if (pathMap.count() == X) return index
        }
        return CANNOT_CROSS_RIVER
    }


    @Test
    fun test() {
        val input = intArrayOf(1, 3, 1, 4, 2, 4, 3, 5)

        Assert.assertEquals(6, solution(5, input))
    }

}
