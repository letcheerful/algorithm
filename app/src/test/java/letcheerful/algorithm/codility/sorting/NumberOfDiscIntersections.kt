package letcheerful.algorithm.codility.sorting

import org.junit.Assert
import org.junit.Test

class NumberOfDiscIntersections {

    sealed class RangePosition(val position: Long) {
        class RangeStart(position: Long) : RangePosition(position)
        class RangeEnd(position: Long) : RangePosition(position)
    }

    fun solution(A: IntArray): Int {

        val positions = ArrayList<RangePosition>()

        A.forEachIndexed { position, radius ->
            val start = position.toLong() - radius
            val end = position.toLong() + radius + 1
            positions.add(RangePosition.RangeStart(start))
            positions.add(RangePosition.RangeEnd(end))
        }

        val sortedPositions = positions.sortedBy { it.position }

        var total = 0
        var intersections = 0

        for(index in 1 until sortedPositions.lastIndex) {
            val position = sortedPositions[index]
            when(position) {
                is RangePosition.RangeStart -> {
                    intersections++

                    total += intersections
//                    println("Total = $total, intersections = $intersections")

                    if(total > 10000000) return -1
                }
                is RangePosition.RangeEnd -> intersections--
            }
        }


        return total

    }

    @Test
    fun testSolution() {
        val input = intArrayOf(1, 2147483647, 0)

        Assert.assertEquals(2, solution(input))
    }

}