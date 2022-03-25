fun main() {

    println("Cyclic Sort #1 Easy -------------------")
    println("Input: [3, 1, 5, 4, 2]\n" +
            "expected: [1, 2, 3, 4, 5]\n" +
            "actual: ${sort(mutableListOf(3, 1, 5, 4, 2))}")

    println("Input: [2, 6, 4, 3, 1, 5]\n" +
            "expected: [1, 2, 3, 4, 5, 6]\n" +
            "actual: ${sort(mutableListOf(2, 6, 4, 3, 1, 5))}")

    println("Input: [1, 5, 6, 4, 3, 2]\n" +
            "expected: [1, 2, 3, 4, 5, 6]\n" +
            "actual: ${sort(mutableListOf(2, 6, 4, 3, 1, 5))}")

}

fun sort(list: MutableList<Int>): MutableList<Int> {
    for(index in list.indices) {
        while(list[index] != index+1) {
            val temp = list[index] // 3
            list[index] = list[temp-1] // 5
            list[temp-1] = temp
        }
    }
    return list
}