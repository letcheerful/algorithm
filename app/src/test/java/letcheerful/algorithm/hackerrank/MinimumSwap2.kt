package letcheerful.algorithm.hackerrank

import org.junit.Assert
import org.junit.Test
import java.util.*
import kotlin.collections.ArrayList

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class MinimumSwap2 {

    // Complete the minimumSwaps function below.
    fun minimumSwaps(arr: Array<Int>): Int {
        var numberOfSwaps = 0
        var index = 0

        while (index <= arr.lastIndex) {
            val value = arr[index]
            val swappingIndex = value - 1

            if (swappingIndex == index) index++
            else {
//                arr.swap(index, swappingIndex)
                numberOfSwaps++
            }
        }
        return numberOfSwaps
    }

    fun minimumSwaps2(arr: Array<Int>): Int {
        val n = arr.size

        // Create two arrays and use as pairs where first
        // array is element and second array
        // is position of first element
        val arrpos = ArrayList<Pair<Int, Int>>()
        for (i in 0 until n)
            arrpos.add(Pair(arr[i], i))

        // Sort the array by array element values to
        // get right position of every element as the
        // elements of second array.
        arrpos.sortBy { it.first }

        // To keep track of visited elements. Initialize
        // all elements as not visited or false.
        val vis = arrayOfNulls<Boolean>(n)
        Arrays.fill(vis, false)

        // Initialize result
        var ans = 0

        // Traverse array elements
        for (i in 0 until n) {
            // already swapped and corrected or
            // already present at correct pos
            if (vis[i] == true || arrpos[i].second == i)
                continue

            // find out the number of  node in
            // this cycle and add in ans
            var cycle_size = 0
            var j = i
            while (vis[j] != true) {
                vis[j] = true

                // move to ReformPhoneNumber node
                j = arrpos[j].second
                cycle_size++
            }

            // Update answer by adding current cycle.
            if (cycle_size > 0) {
                ans += cycle_size - 1
            }
        }

        // Return result
        return ans
    }


//    @Test
//    fun test() {
//        (0..10000000).forEach {
//            val input1 = "1 3 5 2 4 6 7".toIntArray()
//            val expected1 = 3
//
//            Assert.assertEquals(expected1, minimumSwaps(input1))
//
//            val input2 = "2 3 4 1 5".toIntArray()
//            val expected2 = 3
//
//            Assert.assertEquals(expected2, minimumSwaps(input2))
//        }
//    }
//
//    @Test
//    fun test2() {
//        (0..10000000).forEach {
//            val input1 = "1 3 5 2 4 6 7".toIntArray()
//            val expected1 = 3
//
//            Assert.assertEquals(expected1, minimumSwaps2(input1))
//
//            val input2 = "2 3 4 1 5".toIntArray()
//            val expected2 = 3
//
//            Assert.assertEquals(expected2, minimumSwaps2(input2))
//        }
//    }

}
