package letcheerful.algorithm.codility

import org.junit.Assert
import org.junit.Test
import kotlin.math.min

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class GenomicRangeQuery {

    fun solution(S: String, P: IntArray, Q: IntArray): IntArray {

        class Query(val startIndex: Int, val endIndex: Int)

        val MIN_IMPACT = 1
        val MAX_IMPACT = 4

        val impactMap = mapOf('A' to 1, 'C' to 2, 'G' to 3, 'T' to 4)
        val queries = P.zip(Q).map { Query(it.first, it.second) }

        val impacts = S.map { impactMap[it] }

        return queries.map {
            val subImpacts = impacts.subList(it.startIndex, it.endIndex + 1)
            var minimumImpact = MAX_IMPACT

            for(impact in subImpacts) {
                minimumImpact = min(minimumImpact, impact ?: MAX_IMPACT)
                if(minimumImpact == MIN_IMPACT) break

            }

            minimumImpact
        }.toIntArray()
    }
//
//    fun solution(S: String, P: IntArray, Q: IntArray): IntArray {
//
//        class Query(val startIndex: Int, val endIndex: Int)
//
//        val listA = ArrayList<Int>()
//        val listC = ArrayList<Int>()
//        val listG = ArrayList<Int>()
//        val listT = ArrayList<Int>()
//
//        S.forEachIndexed { index, c ->
//            when (c) {
//                'A' -> listA.add(index)
//                'C' -> listC.add(index)
//                'G' -> listG.add(index)
//                'T' -> listT.add(index)
//            }
//        }
//        val queries = P.zip(Q).map { Query(it.first, it.second) }
//
//        val minimumImpacts = queries.map { query ->
//            var minimumImpact: Int? = null
//            val range = (query.startIndex..query.endIndex)
//
//            for(index in listA) {
//                if(range.contains(index)) {
//                    minimumImpact = 1
//                    break
//                }
//            }
//
//            if(minimumImpact == null) {
//                for(index in listC) {
//                    if(range.contains(index)) {
//                        minimumImpact = 2
//                        break
//                    }
//                }
//            }
//
//            if(minimumImpact == null) {
//                for(index in listG) {
//                    if(range.contains(index)) {
//                        minimumImpact = 3
//                        break
//                    }
//                }
//            }
//
//            if(minimumImpact == null) {
//                for(index in listT) {
//                    if(range.contains(index)) {
//                        minimumImpact = 4
//                        break
//                    }
//                }
//            }
//
//            minimumImpact ?: 0
//        }
//
//        return minimumImpacts.toIntArray()
//    }

    @Test
    fun test() {
        val dnaSequence = "CAGCCTA"
        val P = intArrayOf(2, 5, 0)
        val Q = intArrayOf(4, 5, 6)
        val expected = intArrayOf(2, 4, 1)

        Assert.assertArrayEquals(expected, solution(dnaSequence, P, Q))
    }

}
