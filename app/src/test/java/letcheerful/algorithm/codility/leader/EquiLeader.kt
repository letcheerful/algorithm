package letcheerful.algorithm.codility.leader

import org.junit.Assert
import org.junit.Test

class EquiLeader {

    fun solution(A: IntArray): Int {

        class NumberGroup {

            private val numberMap = HashMap<Int, Int>()
            var totalCount = 0
                private set

            fun add(number: Int) {
                numberMap.compute(number) { _, oldCount -> (oldCount ?: 0) + 1 }
            }

            fun remove(number: Int) {
                numberMap.compute(number) { number, oldCount ->
                    when (oldCount) {
                        null -> {
                            null
                        }
                        0 -> {
                            numberMap.remove(number)
                            null
                        }
                        1 -> {
                            totalCount--
                            numberMap.remove(number)
                            null
                        }
                        else -> {
                            totalCount--
                            oldCount - 1
                        }
                    }
                }
            }

            val leader: Int?
                get() {
                    val max = numberMap.maxBy { it.value }
                    val maxCount = max?.value ?: 0
                    val maxNumber = max?.key

                    return if (maxCount >= totalCount / 2) maxNumber else null
                }


            override fun toString(): String {
                return numberMap.toList().toString()
            }
        }

        val leftGroup = NumberGroup()
        val rightGroup = NumberGroup().apply { A.forEach { add(it) } }

        var leaderCount = 0

        for (index in 0 until A.lastIndex) {
            val number = A[index]

            leftGroup.add(number)
            rightGroup.remove(number)

            val leftLeader = leftGroup.leader
            val rightLeader = rightGroup.leader

            println("leftGroup = $leftGroup, rightGroup = $rightGroup")
            println("leftLeader = $leftLeader, rightLeader = $rightLeader")

            if (leftLeader != null && rightLeader != null && leftLeader == rightLeader) leaderCount++
        }

        return leaderCount
    }

    @Test
    fun test() {
        Assert.assertEquals(0, solution(intArrayOf(1)))
        Assert.assertEquals(2, solution(intArrayOf(4, 3, 4, 4, 4, 2)))
    }
}