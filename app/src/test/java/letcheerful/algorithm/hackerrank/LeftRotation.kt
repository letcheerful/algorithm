package letcheerful.algorithm.hackerrank

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class LeftRotation {

    // Complete the rotLeft function below.
    private fun rotLeft(a: Array<Int>, d: Int): Array<Int> {
        val numberOfNeedToRotate = d % a.size

        val frontStartIndex = numberOfNeedToRotate
        val frontEndIndex = a.lastIndex
        val front = a.sliceArray(IntRange(frontStartIndex, frontEndIndex))

        val backStartIndex = 0
        val backEndIndex = frontStartIndex - 1
        val back = a.sliceArray(IntRange(backStartIndex, backEndIndex))

        return front + back
    }

    @Test
    fun test() {
        fun String.toIntArray() : Array<Int> {
            return this.filter { it.isDigit() }.map { it.toString().toInt() }.toTypedArray()
        }

        val input = "1 2 3 4 5".toIntArray()
        val expected = "5 1 2 3 4".toIntArray()

        assertArrayEquals(expected, rotLeft(input, 4))
    }
}
