package letcheerful.algorithm.codility

import org.junit.Assert
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class MissingInteger {

    // Complete the arrayManipulation function below.
    fun solution(A: IntArray): Int {

        val checkMap = HashMap<Int, Boolean>()

        A.forEach { if(it > 0) { checkMap[it] = true } }

        var number = 1

        while(true) {
            if(checkMap[number] == null) break
            else number++
        }

        return number
    }

    @Test
    fun test() {
        val input = intArrayOf(0, 100, 101)

        Assert.assertEquals(1, solution(input))
    }

}
