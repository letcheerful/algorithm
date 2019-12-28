package letcheerful.algorithm.grab

import org.junit.Assert
import org.junit.Test
import kotlin.math.max

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class Coin {

    fun solution(A: IntArray): Int {

        var numberOfReversing = 0

        for(index in 0..(A.lastIndex - 2)) {
            val first = A[index]
            val second = A[index + 1]
            val third = A[index + 2]

            when{
                first == 0 && second == 0 && third == 1 -> {
                    A[index] = 1
                    numberOfReversing++
                }
                first == 1 && second == 1 && third == 0 -> {
                    A[index]     = 0
                    numberOfReversing++
                }

                first == 0 && second == 0 && third == 0 -> {
                    A[index + 1] = 1
                    numberOfReversing++
                }
                first == 1 && second == 1 && third == 1 -> {
                    A[index + 1] = 0
                    numberOfReversing++
                }

                first == 1 && second == 0 && third == 0 -> {
                    A[index + 2] = 1
                    numberOfReversing++
                }
                first == 0 && second == 1 && third == 1 -> {
                    A[index + 2] = 0
                    numberOfReversing++
                }
            }
        }
        return numberOfReversing
    }

    @Test
    fun test() {
        Assert.assertEquals(1, solution(intArrayOf(1, 0, 1, 0, 1, 1)))
        Assert.assertEquals(2, solution(intArrayOf(1, 1, 1, 0, 1, 1, 1)))
        Assert.assertEquals(2, solution(intArrayOf(0, 0, 1, 0, 1, 0, 0)))
        Assert.assertEquals(2, solution(intArrayOf(0, 1, 1, 0)))
    }
}
