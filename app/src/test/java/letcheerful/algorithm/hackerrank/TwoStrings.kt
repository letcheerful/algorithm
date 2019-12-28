package letcheerful.algorithm.hackerrank

import org.junit.Assert
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class TwoStrings {

    // Complete the twoStrings function below.
    fun twoStrings(s1: String, s2: String): String {
        val bit1 = s1.fold(0x0) { bit, character ->
            bit or (1 shl (character - 'a'))
        }
        val bit2 = s2.fold(0x0) { bit, character ->
            bit or (1 shl (character - 'a'))
        }

        return if((bit1 and bit2) != 0) "Yes" else "No"
    }


    @Test
    fun test() {
        Assert.assertEquals("Yes", twoStrings("hello", "world"))
        Assert.assertEquals("No", twoStrings("hi", "world"))
    }

}
