package letcheerful.algorithm.hackerrank

import org.junit.Assert
import org.junit.Test
import kotlin.math.abs

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class MakingAnagrams {

    // Complete the makeAnagram function below.
    fun makeAnagram(a: String, b: String): Int {

        val characterMap = HashMap<Char, Int>()

        a.forEach {
            characterMap[it] = (characterMap[it] ?: 0) + 1
        }
        b.forEach {
            characterMap[it] = (characterMap[it] ?: 0) - 1
        }

        return characterMap.map { abs(it.value) }.sum()
    }

    @Test
    fun test() {
        Assert.assertEquals(30, makeAnagram("fcrxzwscanmligyxyvym", "jxwtrhvujlmrpdoqbisbwhmgpmeoke"))
    }

}
