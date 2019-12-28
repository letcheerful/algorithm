package letcheerful.algorithm.hackerrank

import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class NewYearChaos {

    // Complete the minimumBribes function below.
    private fun minimumBribes(q: Array<Int>) {
        var totalNumberOfBrides = 0

        for (peopleIndex in q.lastIndex downTo 0) {

            println(q.map { it })

            val original = peopleIndex + 1
            val numberOfBrides = when {
                peopleIndex - 2 >= 0 && q[peopleIndex - 2] == original -> {
                    q.move(peopleIndex, peopleIndex - 2)
                    2
                }
                peopleIndex - 1 >= 0 && q[peopleIndex - 1] == original -> {
                    q.move(peopleIndex, peopleIndex - 1)
                    1
                }
                q[peopleIndex] == original -> {
                    0
                }
                peopleIndex + 1 <= q.lastIndex && q[peopleIndex + 1] == original -> {
                    q.move(peopleIndex, peopleIndex + 1)
                    1
                }
                peopleIndex + 2 <= q.lastIndex && q[peopleIndex + 2] == original -> {
                    q.move(peopleIndex, peopleIndex + 2)
                    2
                }
                else -> return println("Too chaotic")
            }

            totalNumberOfBrides += numberOfBrides
        }

        return println(totalNumberOfBrides)
    }

    @Test
    fun test() {
        fun String.toIntArray(): Array<Int> {
            return this.filter { it.isDigit() }.map { it.toString().toInt() }.toTypedArray()
        }

        fun Array<Int>.toSpaceString(): String {
            return this.foldIndexed("") { index, string, i ->
                string + i.toString() + if (index != this.lastIndex) " " else ""
            }
        }

        val input = "1 2 5 3 7 8 6 4".toIntArray()
        val expected = "3"

        minimumBribes(input)
    }
}
