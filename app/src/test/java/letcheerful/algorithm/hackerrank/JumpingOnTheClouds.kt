package letcheerful.algorithm.hackerrank

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class JumpingOnTheClouds {

    val THUNDERHEADS = 1
    val CUMULUS = 0

    // Complete the jumpingOnClouds function below.
    private fun jumpingOnClouds(c: Array<Int>): Int {

        val firstCloudIndex = 0
        val lastCloudIndex = c.size - 1
        var cloudIndex = firstCloudIndex
        var numberOfJumping = 0

        while (cloudIndex < lastCloudIndex) {

            cloudIndex += when {
                (cloudIndex + 2 <= lastCloudIndex) && CUMULUS == c[cloudIndex + 2] -> 2
                (cloudIndex + 1 <= lastCloudIndex) && CUMULUS == c[cloudIndex + 1] -> 2
                else -> throw Exception("Invalid situation!!")
            }
            numberOfJumping++
        }

        return numberOfJumping
    }

    @Test
    fun testCase1() {
        val testCase = "0 0 0 1 0 0".filter { it.isDigit() }.map { it.toString().toInt() }
        val array = Array(testCase.size) { index: Int -> testCase[index] }

        val result = jumpingOnClouds(array)

        assertEquals(3, result)
    }
}
