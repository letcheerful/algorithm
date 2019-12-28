package letcheerful.algorithm.hackerrank

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class CountingValleys {

    companion object {
        private const val UP_HILL = 'U'
        private const val DOWN_HILL = 'D'
        private const val SEE_LEVEL = 0
    }

    // Complete the countingValleys function below.
    fun countingValleys(n: Int, s: String): Int {

        var altitude = SEE_LEVEL
        var numberOfValleys = 0
        var wasInValley = false

        s.forEach {
            altitude += when (it) {
                UP_HILL -> 1
                DOWN_HILL -> -1
                else -> throw Exception("Invalid Action!")
            }

            numberOfValleys += if (altitude == SEE_LEVEL && wasInValley) 1 else 0
            wasInValley = altitude < SEE_LEVEL
        }

        return numberOfValleys
    }

    @Test
    fun testCase1() {
        val testCase = "DDUUDDUDUUUD"
        val result = countingValleys(testCase.length, testCase)

        assertEquals(2, result)
    }
}
