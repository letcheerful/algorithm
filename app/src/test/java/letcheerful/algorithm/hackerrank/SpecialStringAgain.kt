package letcheerful.algorithm.hackerrank

import org.junit.Assert
import org.junit.Test
import kotlin.math.min

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class SpecialStringAgain {
    // Complete the substrCount function below.
    fun substrCount(n: Int, s: String): Long {

        val countCharPairs = ArrayList<Pair<Char, Long>>()

        var currentChar:Char? = null
        var currentCount = 1L

        for(char in s) {
            when(currentChar) {
                null -> {
                    currentChar = char
                    currentCount = 1L
                }
                char -> currentCount++
                else -> {
                    countCharPairs.add(Pair(currentChar, currentCount))

                    currentChar = char
                    currentCount = 1
                }
            }
        }
        countCharPairs.add(Pair(currentChar ?: ' ', currentCount))

        var numberOfPatternMatches = 0L
        var previous: Pair<Char, Long>? = null

        for(index in countCharPairs.indices) {

            val current = countCharPairs[index]
            val next = if(index < countCharPairs.lastIndex) countCharPairs[index + 1] else null

            numberOfPatternMatches += (1..current.second).sum()

            if(previous != null && next != null) {
                if(current.second == 1L && previous.first == next.first) {
                    numberOfPatternMatches += min(previous.second, next.second)
                }
            }

            previous = current
        }

        return numberOfPatternMatches
    }

    @Test
    fun test() {
        Assert.assertEquals(7, substrCount(5, "asasd"))
        Assert.assertEquals(10, substrCount(7, "abcbaba"))
        Assert.assertEquals(10, substrCount(4, "aaaa"))
    }

}
