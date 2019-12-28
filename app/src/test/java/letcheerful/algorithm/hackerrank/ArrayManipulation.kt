package letcheerful.algorithm.hackerrank

import org.junit.Assert
import org.junit.Test
import kotlin.math.max
import kotlin.math.min

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ArrayManipulation {

    fun IntRange.overlap(range: IntRange): IntRange? {
        return if (this.first > range.last || this.last < range.first) null
        else {
            IntRange(max(this.first, range.first), min(this.last, range.last))
        }
    }

    // Complete the arrayManipulation function below.
    fun arrayManipulation(n: Int, queries: Array<Array<Int>>): Long {
        val values = Array(n + 2) { 0 }

        for(query in queries) {
            val start = query[0]
            val end = query[1]
            val value = query[2]

            values[start] += value
            values[end + 1] -= value
        }

        var max = 0L
        var sum = 0L

        for(index in 1 until values.lastIndex) {
            val value = values[index]
            sum += value
            max = max(max, sum)
        }

        return max
    }


    @Test
    fun test() {
        val queries = "1 5 3\n" +
                "4 8 7\n" +
                "6 9 1"

        val numberOfElement = 10

        val arrays = queries.split("\n")
            .map { it.split(" ").map { it.toInt() } }
            .map { Array(it.size) { index: Int -> it[index] } }
            .toTypedArray()


        Assert.assertEquals(10L, arrayManipulation(numberOfElement, arrays))
    }

}
