package letcheerful.algorithm.codility.leader

import org.junit.Assert
import org.junit.Test

class Dominator {

    fun solution(A: IntArray): Int {
        val intMap = HashMap<Int, Int>()
        val halfCount = A.count() / 2

        A.forEach {
            intMap.compute(it) { _, oldValue -> (oldValue ?: 0) + 1 }
        }

        val maxPair = intMap.toList().maxBy { it.second }

        return when {
            maxPair == null -> -1
            maxPair.second < halfCount -> -1
            maxPair.second > halfCount -> {
                A.indexOf(maxPair.first)
            }
            else -> -1
        }
    }

    @Test
    fun test() {
        Assert.assertEquals(-1, solution(intArrayOf(2, 1, 1, 3)))


    }
}