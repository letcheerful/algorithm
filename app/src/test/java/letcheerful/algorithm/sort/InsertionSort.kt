package letcheerful.algorithm.sort

import org.junit.Assert
import org.junit.Test
import java.lang.Math.random


class InsertionSort<T : Comparable<T>> {

    fun sort(array: Array<T>) {
        var buffer:T

        for(keyIndex in 1..array.lastIndex) { // 첫번째는 자기 자신밖에 삽입할 수 없기 때문에 두번째부터 삽입을 시작
            for(insertionIndex in 0 until keyIndex) { // 0부터 선택된 항목의 바로 앞까지 비교를 시작
                if(array[keyIndex] < array[insertionIndex]) {  // 만약 선택된 항목이 삽입 대상 항목보다 작은 경우 아래 삽입을 진행
                    // 선택된 항목을 버퍼에 저장
                    buffer = array[keyIndex]
                    // 삽입할 항목부터 선택된 항목의 바로 앞까지 복사하여 삽입할 항목 다음부터 복사를 진행, 즉 선택된 항목까지 한칸 밀려서 덮어 씌움
                    array.copyInto(array, insertionIndex + 1, insertionIndex, keyIndex)
                    // 버퍼에 저장했던 선택된 항목을 삽입할 위치에 복사
                    array[insertionIndex] = buffer
                }
            }

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
        val sort = InsertionSort<Int>()
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