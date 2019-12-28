package letcheerful.algorithm.codility

import org.junit.Assert
import org.junit.Test
import kotlin.math.max

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class PermMissingElem {

    fun solution(A: IntArray): Int {
        val map = HashMap<Int, Boolean>()

        A.forEach { map[it] = true }

        var number = 1

        while(map[number] != null) {
            number++
        }

        return number
    }


    @Test
    fun test() {
        Assert.assertEquals(4, solution(intArrayOf(2, 3, 1, 5)))
    }

}
