package letcheerful.algorithm.codility

import org.junit.Assert
import org.junit.Test
import kotlin.math.max

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class FrogJmp {

    fun solution(X: Int, Y: Int, D: Int): Int {
        val distance = Y - X
        val quotient = distance / D
        val reminder = distance - (quotient * D)

        return quotient + if(reminder > 0) 1 else 0
    }


    @Test
    fun test() {
        Assert.assertEquals(3, solution(10, 85, 30))
    }

}
