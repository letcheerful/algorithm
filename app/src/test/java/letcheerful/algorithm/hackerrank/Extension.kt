package letcheerful.algorithm.hackerrank

fun String.toIntArray(): Array<Int> {
    return this.filter { it.isDigit() }.map { it.toString().toInt() }.toTypedArray()
}

fun Array<Int>.toSpaceString(): String {
    return this.foldIndexed("") { index, string, i ->
        string + i.toString() + if (index != this.lastIndex) " " else ""
    }
}

fun <T> Array<T>.swap(firstIndex: Int, secondIndex: Int) {
    val temp = this[firstIndex]
    this[firstIndex] = this[secondIndex]
    this[secondIndex] = temp
}

fun <T> Array<T>.move(firstIndex: Int, secondIndex: Int) {
    if (firstIndex < secondIndex) {
        for (index in firstIndex until secondIndex) {
            swap(index, index + 1)
        }
    } else {
        for (index in secondIndex until firstIndex) {
            swap(index, index + 1)
        }
    }
}
