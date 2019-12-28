package letcheerful.algorithm.woowa

import org.junit.Assert
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class number1 {

    // Complete the arrayManipulation function below.
    fun solution(U: Int, L: Int, C: IntArray): String {
        var upperLeft = U
        var lowerLeft = L

        val length = C.count()

        val upperList = IntArray(length) { 0 }
        val lowerList = IntArray(length) { 0 }

        for(index in C.indices) {
            val isPossible = when(C[index]) {
                0 -> {
                    /* Do nothing */
                    true
                }
                1 -> {
                    when {
                        upperLeft != 0 -> {
                            upperList[index] = 1
                            upperLeft--
                            true
                        }
                        lowerLeft != 0 -> {
                            lowerList[index] = 1
                            lowerLeft--
                            true
                        }
                        else -> false
                    }
                }
                2 -> {
                    if(upperLeft > 0 && lowerLeft > 0) {
                        upperList[index] = 1
                        lowerList[index] = 1
                        upperLeft--
                        lowerLeft--
                        true
                    } else {
                        false
                    }
                }
                else -> false
            }

            if(!isPossible) return "IMPOSSIBLE"
        }
        return upperList.joinToString(separator = "") { it.toString() } +
                ","+ lowerList.joinToString(separator = "") { it.toString() }
    }

    @Test
    fun test() {
        Assert.assertEquals(2, solution(2, 2, intArrayOf(2, 0, 2, 0)))
    }

}
