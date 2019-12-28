package letcheerful.algorithm.sort

import letcheerful.algorithm.hackerrank.swap
import org.junit.Assert
import org.junit.Test
import java.lang.Math.min
import java.lang.Math.random


class SelectionSort<T : Comparable<T>> {

    fun sort(array: Array<T>) {

        for(indexA in 0 until array.lastIndex) { //0부터 마지막 바로 전 항목까지 선택한다.(앞에서 이미 정렬되어 마지막 항목은 검토할 필요가 없다.)
            // 사직은 선택된 항목을 최소값을 가진 인덱스로 지정
            var minIndex = indexA

            for(indexB in (indexA + 1)..array.lastIndex) { // 선택된 항목 다음부터 마지막항목까지 확인
                if(array[minIndex] > array[indexB]) { // 최소 인덱스를 찾기 위해 만약 최소 인덱스로 선정된 값보다 비교한 항목이 작은 경우 최소 인덱스를 해당 인덱스로 대입한다.
                    minIndex = indexB
                }
            }
            // 최소 인덱스와 선택된 인덱스의 값을 교환하여 최소 값을 맨 앞으로 하나씩 쌓는다.
            array.swap(indexA, minIndex)

            println(array.toList())
        }
    }

    @Test
    fun testSearchLast() {
//        (0..10).forEach{ _ ->
            test()
//        }
    }

    fun test() {
        val sort = SelectionSort<Int>()
//        val input = (0..10000).map { (random() * 1000).toInt() }.toTypedArray()
        val input = arrayOf(5, 1, 3, 2, 4)
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