package letcheerful.algorithm.hackerrank

import org.junit.Assert
import org.junit.Test
import kotlin.math.abs

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class AlternatingCharacters {

    // Complete the alternatingCharacters function below.
    fun alternatingCharacters(s: String): Int {

        var previous = s.first()
        var numberOfDuplication = 0

        for(index in 1..s.lastIndex) {
            val character = s[index]
            if(character == previous) numberOfDuplication++
            previous = character
        }

        return numberOfDuplication
    }

    @Test
    fun test() {
        Assert.assertEquals(3, alternatingCharacters("AAAA"))
        Assert.assertEquals(4, alternatingCharacters("BBBBB"))
        Assert.assertEquals(0, alternatingCharacters("ABABABAB"))
        Assert.assertEquals(0, alternatingCharacters("BABABA"))
        Assert.assertEquals(4, alternatingCharacters("AAABBB"))
    }

}
