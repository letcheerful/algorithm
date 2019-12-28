package letcheerful.algorithm.codility

import org.junit.Assert
import org.junit.Test
import kotlin.math.min

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class MinAvgTwoSlice {

    fun solution(A: IntArray): Int {
        // write your code in Kotlin
//        인덱스를 증가시키고 계속 더하면서 현재의 최소값과 범뤼를 유지하다가 이후 평균값이 현재보다 낮으면 더해주고 범위를 바꾼다.

        var min = Double.MAX_VALUE
        var minIndex = 0

        for(index in 0 until A.lastIndex) {
            val pairSum = A[index] + A[index + 1]
            val pairAvg = pairSum / 2.0

            println("pairSum = $pairSum, pairAvg = $pairAvg")


            if(min > pairAvg) {
                minIndex = index
                min = pairAvg
            }

            if(index < A.lastIndex - 1) {
                val tripleSum = pairSum + A[index + 2]
                val tripleAvg = tripleSum / 3.0

                println("tripleSum = $tripleSum, tripleAvg = $tripleAvg")

                if(min > tripleAvg) {
                    minIndex = index
                    min = tripleAvg
                }
            }
        }

        return minIndex
    }

    @Test
    fun test() {
        val input = intArrayOf(-3, -5, -8, -4, -10)

        Assert.assertEquals(2, solution(input))
    }

}
