package letcheerful.algorithm.codility

import org.junit.Assert
import org.junit.Test
import kotlin.math.abs
import kotlin.math.max

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class CyclicRotation {

    fun solution(A: IntArray, K: Int): IntArray {

        val count = A.count()
        val rotated = IntArray(count)
        val rotation = if(count == 0) 0 else K % count


        (0 until count).forEach {
            var rotatedIndex = it - rotation

            rotatedIndex = if(rotatedIndex < 0) count + rotatedIndex else rotatedIndex
            rotated[it] = A[rotatedIndex]
        }

        return rotated
    }


    @Test
    fun test() {
        Assert.assertArrayEquals(intArrayOf(), solution(intArrayOf(), 1))
    }

}
