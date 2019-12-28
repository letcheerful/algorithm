package letcheerful.algorithm.woowa

import org.junit.Assert
import org.junit.Test
import kotlin.math.abs
import kotlin.math.max

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class number3 {

    fun solution(A: IntArray): Int {
        val integerMap = HashMap<Int, Boolean>()

        return A.fold(0, { max, integer ->
            integerMap[integer] = true

            if(integerMap[-integer] == true)
                max(max, abs(integer))
            else
                max
        })
    }

    @Test
    fun test() {
        Assert.assertEquals(3, solution(intArrayOf(3, 2, -2, 5, -3)))
        Assert.assertEquals(1, solution(intArrayOf(1, 1, 2, -1, 2, -1)))
        Assert.assertEquals(0, solution(intArrayOf(1, 2, 3, -4)))
    }

}
