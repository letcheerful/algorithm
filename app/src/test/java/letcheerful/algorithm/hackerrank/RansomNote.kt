package letcheerful.algorithm.hackerrank

import org.junit.Test
import java.lang.Exception

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class RansomNote {

    // Complete the checkMagazine function below.
    fun checkMagazine(magazine: Array<String>, note: Array<String>): Unit {

        val magazineMap = mutableMapOf<String, Int>()

        magazine.forEach {
            magazineMap[it] = (magazineMap[it] ?: 0) + 1
        }

        val allMatches = note
            .map {
                if (magazineMap.containsKey(it)) {
                    when (val numberOfWords = magazineMap[it] ?: 0) {
                        0 -> throw Exception("No way!")
                        1 -> magazineMap.remove(it)
                        else -> magazineMap[it] = numberOfWords - 1
                    }
                    true
                } else false
            }
            .reduce { allMatches, matches ->
                allMatches && matches
            }

        println(if (allMatches) "Yes" else "No")
    }


    @Test
    fun test() {
        val magazine = "give me one grand today night"
        val note = "give one grand today"


        val magazineArray = magazine.split(" ").toTypedArray()
        val noteArray = note.split(" ").toTypedArray()

        checkMagazine(magazineArray, noteArray)
    }

    @Test
    fun test2() {
        val magazine = "two times three is not four"
        val note = "two times two is four"


        val magazineArray = magazine.split(" ").toTypedArray()
        val noteArray = note.split(" ").toTypedArray()

        checkMagazine(magazineArray, noteArray)
    }

}
