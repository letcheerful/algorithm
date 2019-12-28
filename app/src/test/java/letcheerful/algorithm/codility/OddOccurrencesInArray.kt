package letcheerful.algorithm.codility

import org.junit.Assert
import org.junit.Test
import kotlin.math.max

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class OddOccurrencesInArray {

    fun solution(A: IntArray): Int {
        return A.reduce { acc, i -> acc xor i }
    }

    @Test
    fun test() {
        Assert.assertEquals(7, solution(intArrayOf(9, 3, 9, 3, 9, 7, 9)))
    }

}
