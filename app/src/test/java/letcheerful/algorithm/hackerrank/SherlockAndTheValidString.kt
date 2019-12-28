package letcheerful.algorithm.hackerrank

import org.junit.Assert
import org.junit.Test
import kotlin.math.abs

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class SherlockAndTheValidString {

    enum class Result {
        YES,
        NO
    }

    // Complete the isValid function below.
    fun isValid(s: String): String {
        val countMap = HashMap<Char, Int>()

        s.forEach { countMap[it] = (countMap[it] ?: 0) + 1 }

        val counts = countMap.values

        val typeMap = HashMap<Int, Int>()

        counts.forEach {
            typeMap[it] = (typeMap[it] ?: 0) + 1
        }

        // 맵의 크기가 2이상이면 안되고 작은 것의

        return when(typeMap.count()) {
            1 -> "YES"
            2 -> {
                val keyList = typeMap.keys.toList()
                val firstKey = keyList[0]
                val firstValue = typeMap[firstKey] ?: 0
                val secondKey = keyList[1]
                val secondValue = typeMap[secondKey] ?: 0

                val largeKey = if(firstValue > secondValue) firstKey else secondKey
                val smallKey = if(firstValue > secondValue) secondKey else firstKey

                val largeValue = if(firstValue > secondValue) firstValue else secondValue
                val smallValue = if(firstValue > secondValue) secondValue else firstValue

                return when{
                    smallValue == 1 && smallKey == 1 -> "YES"
                    smallKey - largeKey == 1 && smallValue == 1 -> "YES"
                    else -> "NO"
                }
            }
            else -> "NO"
        }
    }

    @Test
    fun test() {
//        Assert.assertEquals("NO", isValid("aabbcd"))
        Assert.assertEquals("YES", isValid("aabbc"))
//        Assert.assertEquals("YES", isValid("aabbcc"))
//        Assert.assertEquals("YES", isValid("aabbccc"))
    }

}
