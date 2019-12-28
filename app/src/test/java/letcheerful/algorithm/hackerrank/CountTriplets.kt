package letcheerful.algorithm.hackerrank

import org.junit.Assert
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class CountTriplets {

    // Complete the countTriplets function below.
    fun countTriplets(arr: Array<Long>, r: Long): Long {

        var numberOfTriplets = 0L

        val step2Map = hashMapOf<Long, Long>()
        val step3Map = hashMapOf<Long, Long>()

        for(number in arr) {
            val next = number * r

            numberOfTriplets += step3Map[number] ?: 0


            if(step2Map.containsKey(number)) {
                step3Map[next] = (step3Map[next] ?: 0) + (step2Map[number] ?: 0)
            }

            step2Map[next] = (step2Map[next] ?: 0) + 1
        }

        return numberOfTriplets
    }

    fun String.toLongArray(): Array<Long> {
        return this.split(" ").map { it.toLong() }.toTypedArray()
    }

    @Test
    fun test1() {
        val input = "1 2 2 4".toLongArray()

        Assert.assertEquals(2, countTriplets(input, 2))
    }

    @Test
    fun test2() {
        val input = "1 3 9 9 27 81".toLongArray()
        Assert.assertEquals(6, countTriplets(input, 3))
    }

    @Test
    fun test3() {
        val input = "1 2 2 4 4".toLongArray()

        Assert.assertEquals(4, countTriplets(input, 2))
    }

    @Test
    fun test4() {
        val input = "1 2 1 2 4".toLongArray()

        Assert.assertEquals(3, countTriplets(input, 2))
    }
}
