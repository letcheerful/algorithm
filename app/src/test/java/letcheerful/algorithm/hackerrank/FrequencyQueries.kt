package letcheerful.algorithm.hackerrank

import org.junit.Assert
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class FrequencyQueries {

    enum class Operator(val value: Int) {
        INSERT(1),
        DELETE(2),
        CHECK(3);

        companion object {
            private val map = values().associateBy(Operator::value)
            operator fun get(value: Int) = map[value]
        }
    }

    private val MATCHED = 1
    private val NOT_MATCHED = 0

    // Complete the freqQuery function below.
    fun freqQuery(queries: Array<Array<Int>>): Array<Int> {

        val result = arrayListOf<Int>()
        val countMap = hashMapOf<Int, Int>()
        val frequencyMap = hashMapOf<Int, Int>()

        for (query in queries) {
            val operator = query[0]
            val key = query[1]

            when (operator) {
                1 -> {
                    val count = countMap[key]

                    if(count != null) {
                        val frequency = frequencyMap[count]

                        if(frequency != null) {
                            if(frequency == 1) frequencyMap.remove(count)
                            if(frequency > 1) frequencyMap[count] = frequency - 1
                        }
                    }

                    val next = (count ?: 0) + 1

                    countMap[key] = next

                    frequencyMap[next] = (frequencyMap[next] ?: 0) + 1
                }
                2 -> {
                    val count = countMap[key]

                    if(count != null) {
                        val frequency = frequencyMap[count]

                        if(frequency != null) {
                            if(frequency == 1) frequencyMap.remove(count)
                            if(frequency > 1) frequencyMap[count] = frequency - 1
                        }

                        val next = count- 1

                        if(count == 0) countMap.remove(count)
                        if(count > 0) countMap[key] = count - 1

                        frequencyMap[next] = (frequencyMap[next] ?: 0) + 1
                    }
                }
                3 -> result.add(if (frequencyMap.containsKey(key)) MATCHED else NOT_MATCHED)
            }
        }

        return result.toTypedArray()
    }


    @Test
    fun test1() {
        val input = ("1 5\n" +
                "1 6\n" +
                "3 2\n" +
                "1 10\n" +
                "1 10\n" +
                "1 6\n" +
                "2 5\n" +
                "3 2")
            .split("\n")
            .map { line -> line.split(" ").map { it.toInt() }.toTypedArray() }
            .toTypedArray()

        (0..100000).forEach { Assert.assertArrayEquals(arrayOf(0, 1), freqQuery(input)) }
    }

    @Test
    fun test2() {
        val input = ("3 4\n" +
                "2 1003\n" +
                "1 16\n" +
                "3 1")
            .split("\n")
            .map { line -> line.split(" ").map { it.toInt() }.toTypedArray() }
            .toTypedArray()

        (0..100000).forEach { Assert.assertArrayEquals(arrayOf(0, 1), freqQuery(input)) }
    }

    @Test
    fun test3() {
        val input = ("1 3\n" +
                "2 3\n" +
                "3 2\n" +
                "1 4\n" +
                "1 5\n" +
                "1 5\n" +
                "1 4\n" +
                "3 2\n" +
                "2 4\n" +
                "3 2")
            .split("\n")
            .map { line -> line.split(" ").map { it.toInt() }.toTypedArray() }
            .toTypedArray()

        (0..100000).forEach { Assert.assertArrayEquals(arrayOf(0, 1, 1), freqQuery(input)) }
    }

    @Test
    fun test4() {
        val input = ("1 3\n" +
                "1 38\n" +
                "2 1\n" +
                "1 16\n" +
                "2 1\n" +
                "2 2\n" +
                "1 64\n" +
                "1 84\n" +
                "3 1\n" +
                "1 100\n" +
                "1 10\n" +
                "2 2\n" +
                "2 1\n" +
                "1 67\n" +
                "2 2\n" +
                "3 1\n" +
                "1 99\n" +
                "1 32\n" +
                "1 58\n" +
                "3 2")
            .split("\n")
            .map { line -> line.split(" ").map { it.toInt() }.toTypedArray() }
            .toTypedArray()

        (0..100000).forEach { Assert.assertArrayEquals(arrayOf(1, 1, 0), freqQuery(input)) }
    }
}
