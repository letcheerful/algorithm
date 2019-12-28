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
class PermCheck {

    fun solution(A: IntArray): Int {

        val NOT_PERMUTATION = 0
        val PERMUTATION = 1
        val CHECKED = 2
        val UNCHECKED = 3

        val count = A.count()
        val check = IntArray(count + 1) { UNCHECKED }
        val max = count
        var sum = 0
        val permutation = ((count + 1) * count) shr 1

        for(a in A) {
            if(a <=  max && check[a] == UNCHECKED) {
                check[a] = CHECKED
            } else {
                return NOT_PERMUTATION
            }
            sum += a
        }

        return if(sum == permutation) PERMUTATION else NOT_PERMUTATION
    }


    @Test
    fun test() {
        val input = intArrayOf(4, 1, 3, 2)

        Assert.assertEquals(1, solution(input))
    }

}
