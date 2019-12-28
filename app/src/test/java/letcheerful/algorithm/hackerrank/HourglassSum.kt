package letcheerful.algorithm.hackerrank

import org.junit.Test

import org.junit.Assert.*
import kotlin.math.max

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class HourglassSum {

    private fun hourglassSum(arr: Array<Array<Int>>): Int {
        var maxSum = Int.MIN_VALUE

        for(rowIndex in 0 until arr.size - 2) {
            val firstRow = arr[rowIndex]

            for(columnIndex in 0 until firstRow.size - 2) {
                val topPart =
                    arr[rowIndex][columnIndex] + arr[rowIndex][columnIndex + 1] + arr[rowIndex][columnIndex + 2]
                val middlePart = arr[rowIndex + 1][columnIndex + 1]
                val bottomPart =
                    arr[rowIndex + 2][columnIndex] + arr[rowIndex + 2][columnIndex + 1] + arr[rowIndex + 2][columnIndex + 2]

                val sum = topPart + middlePart + bottomPart

                maxSum = max(maxSum, sum)
            }
        }

        return maxSum
    }

    @Test
    fun testCase1() {
        val input = "-1 -1 0 -9 -2 -2\n" +
                "-2 -1 -6 -8 -2 -5\n" +
                "-1 -1 -1 -2 -3 -4\n" +
                "-1 -9 -2 -4 -4 -5\n" +
                "-7 -3 -3 -2 -9 -9\n" +
                "-1 -3 -1 -2 -4 -5"

        val inputArrays = input.split("\n")
            .map { it.split(" ").map { it.toInt() } }
            .map { Array(it.size) { index: Int -> it[index] } }

        println(inputArrays)


        val result = hourglassSum(Array(inputArrays.size) { index:Int -> inputArrays[index]})

        assertEquals(-6, result)
    }
}
