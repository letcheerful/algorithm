package letcheerful.algorithm.search

import org.junit.Assert
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class BinarySearch<T : Comparable<T>> {

    fun search(key: T, sorted: List<T>, start: Int, end: Int): Boolean {

        val centerIndex = start + (end - start) / 2
        val pivot = sorted[centerIndex]

        println("start = $start, end = $end")
        println("pivot index = $centerIndex")
        println("pivot = ${sorted[centerIndex]}")


        return when {
            key == pivot -> true
            key < pivot -> search(key, sorted, start, centerIndex)
            key > pivot -> search(key, sorted, centerIndex, end + 1)
            else -> false
        }
    }


    @Test
    fun testSearchCenter() {
        val binarySearch = BinarySearch<Int>()
        val list = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
        val key = list[list.count() / 2]
        val expected = list.count() / 2

        Assert.assertEquals(expected, binarySearch.search(key, list, 0, list.lastIndex))
    }

    @Test
    fun testSearchFirst() {
        val binarySearch = BinarySearch<Int>()
        val list = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
        val key = list.first()
        val expected = 0

        Assert.assertEquals(expected, binarySearch.search(key, list, 0, list.lastIndex))
    }

    @Test
    fun testSearchLast() {
        val binarySearch = BinarySearch<Int>()
        val list = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
        val key = list.last()
        val expected = list.lastIndex

        Assert.assertEquals(true, binarySearch.search(key, list, 0, list.lastIndex))
    }
}