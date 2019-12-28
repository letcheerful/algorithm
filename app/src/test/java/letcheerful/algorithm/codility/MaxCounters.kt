package letcheerful.algorithm.codility

import org.junit.Assert
import org.junit.Test
import kotlin.math.max

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class MaxCounters {

    enum class Operation {
        INCREASE, // Increase a counter
        MAXIMIZE // Set all counter to max
    }

    fun solution(N: Int, A: IntArray): IntArray {
        val counters = IntArray(N) { 0 }
        var maxCountInCounters = 0
        var maxCountOnMaximize = 0

        for(a in A) {
            val counterIndex = a - 1

            val operation = when (a) {
                N + 1 -> Operation.MAXIMIZE
                else -> Operation.INCREASE
            }

            when(operation) {
                Operation.MAXIMIZE -> {
                    maxCountOnMaximize = maxCountInCounters
                }
                Operation.INCREASE -> {
                    var count = counters[counterIndex]

                    count = max(maxCountOnMaximize, count) + 1
                    counters[counterIndex] = count

                    maxCountInCounters = max(maxCountInCounters, count)
                }
            }
        }

        for(index in counters.indices) {
            counters[index] = max(maxCountOnMaximize, counters[index])
        }

        return counters
    }


    @Test
    fun test() {
        val input = intArrayOf(3, 4, 4 ,6, 1, 4, 4)
        val output = intArrayOf(3, 2, 2, 4, 2)

        Assert.assertArrayEquals(output, solution(5, input))
    }

}
