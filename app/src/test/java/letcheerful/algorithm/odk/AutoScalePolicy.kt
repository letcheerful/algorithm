package letcheerful.algorithm.odk

import org.junit.Assert
import org.junit.Test
import kotlin.math.pow

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class AutoScalePolicy {


    fun finalInstances(instances: Int, averageUtil: Array<Int>): Int {
        // Write your code here
        val MAX_INSTANCES = (2 * 10.0.pow(8)).toInt()

        var currentInstances = instances
        var index = 0

        while (index <= averageUtil.lastIndex) {
            val utilization = averageUtil[index]

            currentInstances = when {
                utilization < 25 && currentInstances > 1 -> {
                    index += 10
                    (currentInstances + 1) / 2
                }
                utilization > 60 && currentInstances <= MAX_INSTANCES -> {
                    index += 10
                    currentInstances * 2

                }
                else -> {
                    currentInstances
                    index++
                }
            }
        }
        return currentInstances
    }

    @Test
    fun testCase1() {
        Assert.assertEquals(
            3, finalInstances(5, arrayOf(6, 30, 5, 4, 8, 19, 89))
        )
    }
}
