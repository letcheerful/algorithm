package letcheerful.algorithm.codility

import org.junit.Assert
import org.junit.Test
import kotlin.math.max

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class BinaryGap {

    fun solution(N: Int): Int {
        // write your code in Kotlin

        var maximumGap = 0
        var gap = 0
        var sifted = N
        var isInGap = false

        while(sifted > 0) {
            val isZero = (sifted and 0x1) == 0x0
            val foundGap = isInGap && !isZero

            if(foundGap) {
                maximumGap = max(maximumGap, gap)
                gap = 0
            }
            if(isInGap && isZero) gap++

            if(!isZero) isInGap = true

            sifted = sifted shr 1
        }

        return maximumGap
    }


    @Test
    fun test() {
        Assert.assertEquals(2, solution(9))
    }

}
