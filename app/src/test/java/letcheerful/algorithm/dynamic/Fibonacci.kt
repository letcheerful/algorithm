package letcheerful.algorithm.dynamic

import org.junit.Assert
import org.junit.Test

class Fibonacci {

    /*
    피보나치 수 F(n)는 다음과 같은 초기값 및 점화식으로 정의되는 수열이다.
    F(1) = F(2) = 1
    F(n) = F(n-1) + F(n-2), n은 {3, 4, ...}
    */


    class Memoization<in A, out R>(val function: (A) -> R) : (A) -> R {

        private val columnMap = hashMapOf<A, R>()

        override fun invoke(x: A): R {
            var value = columnMap[x]

            if(value == null) {
                value = function(x)
                columnMap[x] = value
            }

            return value!!
        }

        fun clear() {
            columnMap.clear()
        }
    }

    private fun <A, R> ((A) -> R).memoize() = Memoization(this)


    val memoization = { x: Int -> findR(x) }.memoize()

    tailrec fun findR(number: Int): Int {
        return if(number < 2) number else {
            findR(number - 1) + findR(number - 2)
        }
    }

    tailrec fun factorial(n: Int, run: Int = 1): Long {
        return if (n == 1) run.toLong() else factorial(n-1, run*n)
    }

    fun find(number: Int): Int {

        var n = 0; var n_1 = 0; var n_2 = 0

        for (index in 0..number) {
            n = when(index) {
                0 -> 0
                1 -> 1
                else -> n_1 + n_2
            }
            n_2 = n_1
            n_1 = n
        }

        return n
    }

    @Test
    fun testFibonacci() {
//        val input = 100000
//        find(input)
//        memoization.invoke(input)
//        Assert.assertEquals(55, find(input))
//        Assert.assertEquals(55, findR(input))


//        val input = listOf(1, 2, 3)
//
//        val output = input.flatMap {
//            val list = ArrayList<Int>()
//            for(value in 0..it) {
//                list.add(value)
//            }
//            list
//        }
//
//        println(output)



    }

    interface test{

        companion object {
            public val test3: Int = 1
        }
        var test:Int
        val test2:Int
    }


    class TestClass(override var test: Int, override val test2: Int) : test{
        companion object {
            public val test3: Int = 1
        }

    }

    @Test
    fun testObject() {



        val testClass = TestClass(1, 2)


    }
}