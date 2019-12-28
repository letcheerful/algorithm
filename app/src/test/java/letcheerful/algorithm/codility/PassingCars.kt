package letcheerful.algorithm.codility

import org.junit.Assert
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class PassingCars {

    fun solution(A: IntArray): Int {

        val TRAVELING_EAST = 0
        val TRAVELING_WEST = 1
        val LIMIT_NUMBER_OF_PAIRS = 1000000000

        var numberOfCarsTravelingEast = 0
        var numberOfPairs = 0

        for (a in A) {
            when (a) {
                TRAVELING_EAST -> {
                    numberOfCarsTravelingEast++
                }
                TRAVELING_WEST -> {
                    numberOfPairs += numberOfCarsTravelingEast
                }
            }
            if (numberOfPairs > LIMIT_NUMBER_OF_PAIRS) {
                numberOfPairs = -1
                break
            }
        }

        return numberOfPairs
    }

    @Test
    fun test() {
        val input = intArrayOf(0, 1, 0, 1, 1)

        Assert.assertEquals(5, solution(input))
    }

}
