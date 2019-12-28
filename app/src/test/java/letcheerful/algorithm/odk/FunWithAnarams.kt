package letcheerful.algorithm.odk

import org.junit.Assert
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class FunWithAnarams {

    fun funWithAnagrams(s: Array<String>): Array<String> {
        // Write your code here
        val analysis = s
            .map { string ->
                HashMap<Char, Int>().also { map ->
                    string.forEach { map[it] = (map[it] ?: 0) + 1 }
                }
            }
            .map { map ->
                val builder = StringBuilder()
                val sortedKeys = map.keys
                sortedKeys.forEach {
                    builder.append(it)
                    builder.append(map[it])
                }
                builder.toString()
            }

        val joinedMap = LinkedHashMap<String, String>()

        for (index in s.indices) {
            val analysisString = analysis[index]
            val anagramString = s[index]

            if (joinedMap[analysisString] == null) joinedMap[analysisString] = anagramString
        }

        return joinedMap.values.sorted().toTypedArray()
    }

    @Test
    fun testCase1() {
        Assert.assertArrayEquals(
            arrayOf("aaagmnrs", "code"),
            funWithAnagrams(arrayOf("code", "aaagmnrs", "anagrams", "doce"))
        )
        Assert.assertArrayEquals(
            arrayOf("avc", "da"),
            funWithAnagrams(arrayOf("da", "ad", "avc", "cva"))
        )
    }
}
