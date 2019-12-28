package letcheerful.algorithm.sort

import letcheerful.algorithm.hackerrank.swap
import org.junit.Assert
import org.junit.Test
import java.lang.Math.random


class BubbleSort<T : Comparable<T>> {

    fun sort(array: Array<T>) {
        for(indexA in 0 until array.lastIndex) { //처음 부터 마지막 바로 앞까지 비교를 시작(두 개의 항목을 비교하기 때문에 마지막 항목은 비교 대상만 된다.)
            for(indexB in (indexA + 1)..array.lastIndex) { //비교 대상은 선택된 항목의 다음 항목부터 마지막 항목까지
                if(array[indexA] > array[indexB]) { //만약 비교 대상이 선택된 항목보다 큰 경우 서로 바꾼다.
                    array.swap(indexA, indexB)
                }
            }
            // 최종적으로 이 하위 사이클을 지나면 첫번째 항목은 가장 작은 값이 배치된다.
        }
    }

    @Test
    fun testSearchLast() {
        (0..10).forEach{ _ ->
            test()
        }
    }

    fun test() {
        val sort = BubbleSort<Int>()
        val input = (0..10000).map { (random() * 1000).toInt() }.toTypedArray()
//        val input = arrayOf(4, 3, 2, 1)
        val expected = input.sorted().toTypedArray()

        sort.sort(input)

        Assert.assertArrayEquals(expected, input)

    }
}

/*
* Before = [3, 1, 2]
Array = [2, 1, 3], leftIndex = 0, rightIndex = 2
Array = [2, 1, 3], leftIndex = 1, rightIndex = 1
After = [2, 1, 3]
*
*
* */