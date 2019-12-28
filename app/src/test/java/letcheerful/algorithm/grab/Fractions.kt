package letcheerful.algorithm.grab

import org.junit.Assert
import org.junit.Test


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class Fractions {

    fun solution(X: IntArray, Y: IntArray): Int {

        val fractionMap = HashMap<Int, HashMap<Int, Int>>()

        fun saveFraction(molecule: Int, denominator: Int) {
            val denominatorMap = fractionMap[molecule] ?: HashMap()
            denominatorMap[denominator] = (denominatorMap[denominator] ?: 0) + 1
            fractionMap[molecule] = denominatorMap
        }

        fun gcd(x: Int, y: Int): Int {
            var temp: Int;
            var left = x;
            var right = y

            while (left != 0) {
                if (left < right) {
                    temp = left; left = right; right = temp // swap
                }
                left -= right
            }
            return right
        }

        for (index in X.indices) {
            val x = X[index]
            val y = Y[index]
            val gcd = gcd(x, y)
            saveFraction(x / gcd, y / gcd)
        }

        return fractionMap.values
            .map { it.values.max() ?: 0 }
            .max() ?: 0
    }


    @Test
    fun test() {
        Assert.assertEquals(3, solution(intArrayOf(0, 0, 0, 1, 1), intArrayOf(2, 3, 6, 8, 4)))
//        Assert.assertEquals(3, solution(intArrayOf(1, 2, 3, 4, 0), intArrayOf(2, 3, 6, 8, 4)))
//        Assert.assertEquals(3, solution(intArrayOf(3, 3, 4), intArrayOf(2, 3, 6, 8, 4)))
    }
}
