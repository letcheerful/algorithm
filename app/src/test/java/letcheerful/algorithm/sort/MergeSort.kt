package letcheerful.algorithm.sort

import org.junit.Assert
import org.junit.Test
import java.lang.Math.random


class MergeSort<T : Comparable<T>> {

    lateinit var buffer: ArrayList<T>


    fun sort(array: Array<T>) {
        // 각 단계에서 정렬된 중간 값들을 답기 위한 버퍼를 생성한다.
        buffer = ArrayList()

        divide(array, 0, array.lastIndex)
    }

    fun merge(array: Array<T>, startIndex: Int, centerIndex: Int, endIndex: Int) {
        var leftIndex = startIndex
        var rightIndex = centerIndex + 1
        var bufferIndex = 0

        // 좌측, 우측의 부분 배열의 값들을 순서대로 선택한다.
        while (leftIndex <= centerIndex && rightIndex <= endIndex) {
            val left = array[leftIndex]
            val right = array[rightIndex]

            when {
                left < right -> {
                    buffer[bufferIndex++] = left
                    leftIndex++
                }
                right < left -> {
                    buffer[bufferIndex++] = right
                    rightIndex++
                }
                right == left -> {
                    buffer[bufferIndex++] = left
                    buffer[bufferIndex++] = right
                    leftIndex++
                    rightIndex++
                }
            }
        }

        // 좌측 또는 우측의 남은 배열을 그대로 복사한다.
        while (leftIndex <= centerIndex) {
            buffer[bufferIndex++] = array[leftIndex++]
        }
        while (rightIndex <= endIndex) {
            buffer[bufferIndex++] = array[rightIndex++]
        }

        // 정렬된 항목의 버퍼를 기존 배열에 복사한다.
        buffer.forEachIndexed { index, value ->
            array[index + startIndex] = value
        }

        // 사용된 버퍼를 초기화한다.
        buffer.clear()
    }

    fun divide(array: Array<T>, startIndex: Int, endIndex: Int) {
        if (startIndex < endIndex) { // 항목 개수가 유효할 경우만 정렬을 진행한다.
            // 나누는 위치를 가운데 인덱스로 정한다.
            val centerIndex = startIndex + (endIndex - startIndex) / 2
            // 좌측 배열을 재귀적으로 정렬한다.
            divide(array, startIndex, centerIndex)
            // 우측 배열을 재귀적으로 정렬한다.
            divide(array, centerIndex + 1, endIndex)

            // 정렬된 배열을 합친다.
            merge(array, startIndex, centerIndex, endIndex)
        }
    }

    @Test
    fun testSearchLast() {
        (0..100).forEach{ _ ->
            test()
        }
    }

    fun test() {
        val mergeSort = MergeSort<Int>()
        val input = (0..10000).map { (random() * 1000).toInt() }.toTypedArray()
//        val input = arrayOf(4, 4, 2, 2)
        val expected = input.sorted().toTypedArray()

        mergeSort.sort(input)

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