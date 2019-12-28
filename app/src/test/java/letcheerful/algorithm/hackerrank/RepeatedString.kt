package letcheerful.algorithm.hackerrank

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class RepeatedString {

    // Complete the repeatedString function below.
    private fun repeatedString(s: String, n: Long): Long {
        val numberOfAlphabetAInString = s.count { it == 'a' }
        val repeatedCount = n / s.length
        val leftCount = n - (repeatedCount * s.length)

        var totalNumberOfAlphabetA = numberOfAlphabetAInString * repeatedCount

        totalNumberOfAlphabetA += s.subSequence(0, leftCount.toInt()).count { it == 'a' }

        return totalNumberOfAlphabetA
    }


    @Test
    fun solve() {
        val testInputs = listOf(
            Pair("aba", 10L),
            Pair("a", 1000000000000L)
        )

        val testOutputs = listOf(
            7L, 1000000000000L
        )

        for (index in testInputs.indices) {
            val result = repeatedString(testInputs[index].first, testInputs[index].second)
            assertEquals(testOutputs[index], result)
        }
    }
}
