package letcheerful.algorithm.grab

import org.junit.Assert
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ReformPhoneNumber {

    fun solution(S: String): String {

        val builder = StringBuilder()
        val digits = S.filter{ it.isDigit() }

        var index = 0

        while (index < digits.lastIndex) {
            val leftDigits = (digits.lastIndex - index) + 1

            val numberOfDigit = when(leftDigits) {
                2, 3 -> leftDigits
                4 -> 2
                else -> 3
            }

            builder.append(digits.subSequence(index, index + numberOfDigit))
            index += numberOfDigit

            if(index < digits.lastIndex) builder.append('-')
        }

        return builder.toString()
    }

    @Test
    fun test() {

        Assert.assertEquals("00", solution("0   0"))
        Assert.assertEquals("00", solution("-0 - 0-"))
        Assert.assertEquals("004-448-555-583-61", solution("00-44  48 5555 8361"))
        Assert.assertEquals("022-198-53-24", solution("0 - 22 1985--324"))
        Assert.assertEquals("555-372-654", solution("555372654"))
    }
}
