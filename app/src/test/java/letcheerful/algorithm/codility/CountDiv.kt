package letcheerful.algorithm.codility

import org.junit.Assert
import org.junit.Test
import kotlin.math.min

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class CountDiv {

    fun solution(A: Int, B: Int, K: Int): Int {
        val a = A / K
        val remainderA = A - a * K

        val left = if(remainderA > 0) a else a - 1
        val right = B / K


        return right - left
    }

    @Test
    fun test() {
        Assert.assertEquals(3, solution(6, 11, 2))
    }

}
