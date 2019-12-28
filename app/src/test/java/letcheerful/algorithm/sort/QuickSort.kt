package letcheerful.algorithm.sort

import letcheerful.algorithm.hackerrank.swap
import org.junit.Assert
import org.junit.Test


class QuickSort<T : Comparable<T>> {

    fun sort(array: Array<T>, startIndex: Int, endIndex: Int) {
        // 항목 개수가 유효할 때만 정렬을 진행한다.
        if (startIndex < endIndex) {
            // 피봇을 마지막 항목으로 정한다.(피봇 정하는 규칙은 매우 다양하다.)
            val pivot = array[endIndex]

            // 피봇보다 작은 값들을 저장하기 위한 인덱스로 피봇보다 작은 값을 찾으면 하나씩 올린다.
            // 맨 앞에서 쌓기 위해 시작 인덱스로 설정.
            var storeIndex = startIndex

            // 시작인덱스부터 마지막을 제외한 항목까지 검토(마지막은 피봇이다.)
            for (index in startIndex until endIndex) {
                // 피봇보다 같거나 작은 경우(여기서 피봇보다 같은 값도 작은 배열에 넣는다고 가정.)
                if(array[index] <= pivot) {
                    // 발견된 작은 값을 저장 위치에 저장하기 위해 현재 검토 중인 항목과 저장 인덱스의 항목을 교환한다.
                    array.swap(storeIndex, index)
                    // 하나가 저장되었기 때문에 저장 위치의 인덱스를 움직인다.
                    storeIndex++
                }
            }

            // 작은 항목의 비교/저장을 마치면 피봇과 큰 값중 첫번째 항목과 피봇을 교환한다.
            array.swap(endIndex, storeIndex)

            // 피봇을 제외한 작은 항목들을 정렬하고
            sort(array, startIndex, storeIndex - 1)
            // 피봇을 제외한 큰 항목들을 정렬한다.
            sort(array, storeIndex + 1, endIndex)
        }
    }

    @Test
    fun testSearchLast() {
//        (0..1000).forEach{
            test()
//        }
    }


    fun test() {
        val quickSort = QuickSort<Int>()
//        val input = (0..10).map { (random() * 1000).toInt() }.toTypedArray()
        val input = arrayOf(5, 1, 3, 2, 4)
        val expected = input.sorted().toTypedArray()

        quickSort.sort(input, 0, input.lastIndex)

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