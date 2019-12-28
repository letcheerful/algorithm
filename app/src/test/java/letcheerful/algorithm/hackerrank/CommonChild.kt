package letcheerful.algorithm.hackerrank

import org.junit.Assert
import org.junit.Test
import kotlin.math.max

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class CommonChild {

    class Memoization<in A, in B, in C, in D, out R>(val function: (A, B, C, D) -> R) :
            (A, B, C, D) -> R {

        private val columnMap = hashMapOf<A, HashMap<B, R>>()

        override fun invoke(x: A, y: B, left: C, right: D): R {
            val rowMap = columnMap.getOrPut(x, { HashMap() })
            return rowMap.getOrPut(y, { function(x, y, left, right) })
        }

        fun clear() {
            columnMap.forEach { key, value ->
                value.clear()
            }
            columnMap.clear()
        }
    }

    private fun <A, B, C, D, R> ((A, B, C, D) -> R).memoize() = Memoization(this)


    private var memoization = { x: Int, y: Int, left: String, right: String ->
        countCommonChildren(
            x,
            y,
            left,
            right
        )
    }.memoize()

    private fun countCommonChildren(leftStart: Int, rightStart: Int, left: String, right: String): Int {

        if (left.lastIndex < leftStart || right.lastIndex < rightStart) return 0

        return if (left[leftStart] == right[rightStart]) {
            memoization.invoke(leftStart + 1, rightStart + 1, left, right) + 1
        } else {
            max(
                memoization.invoke(leftStart + 1, rightStart, left, right)
                ,
                memoization.invoke(leftStart, rightStart + 1, left, right)
            )
        }
    }

    // Complete the commonChild function below.
    fun commonChild(s1: String, s2: String): Int {
        memoization.clear()
        return memoization.invoke(0, 0, s1, s2)
    }

    @Test
    fun test() {
        Assert.assertEquals(2, commonChild("HARRY", "SALLY"))
        Assert.assertEquals(0, commonChild("AA", "BB"))
        Assert.assertEquals(3, commonChild("SHINCHAN", "NOHARAAA"))
        Assert.assertEquals(2, commonChild("ABCDEF", "FBDAMN"))
    }

}
