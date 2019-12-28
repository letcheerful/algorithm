package letcheerful.algorithm.hackerrank

import org.junit.Assert
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class SherlockAndAnagrams {

    // Complete the sherlockAndAnagrams function below.
    fun sherlockAndAnagrams(s: String): Int {

        fun isAnagrams(s1:String, s2:String): Boolean {

            val leftMap = hashMapOf<Char, Int>()

            for(char in s1) {
                leftMap[char] = (leftMap[char] ?: 0) + 1
            }

            val rightMap = hashMapOf<Char, Int>()

            for(char in s2) {
                rightMap[char] = (rightMap[char] ?: 0) + 1
            }

            return leftMap == rightMap
        }

        var numberOfAnagrams = 0

        for(length in 1 until s.length) {

            for(start in 0..(s.lastIndex - length)) {

                val left = s.substring(start, start + length)

                for(end in (start + 1)..(s.lastIndex + 1 - length)){
                    val right = s.substring(end, end + length)

                    if(isAnagrams(left, right)) numberOfAnagrams++
                }
            }
        }

        return numberOfAnagrams
    }


    @Test
    fun test() {
        Assert.assertEquals(4, sherlockAndAnagrams("abba"))
        Assert.assertEquals(0, sherlockAndAnagrams("abcd"))
        Assert.assertEquals(3, sherlockAndAnagrams("ifailuhkqq"))
        Assert.assertEquals(10, sherlockAndAnagrams("kkkk"))
        Assert.assertEquals(5, sherlockAndAnagrams("cdcd"))
    }

}
