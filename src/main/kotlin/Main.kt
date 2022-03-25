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

    println("Cyclic Sort #2 Find Missing Num -------------------")
    println("Input: [4, 0, 3, 1]\n" +
            "Output: 2\n" +
            "actual: ${findMissingNumber(mutableListOf(4, 0, 3, 1))}")
    println("Input: [8, 3, 5, 2, 4, 6, 0, 1]\n" +
            "Output: 7\n" +
            "actual: ${findMissingNumber(mutableListOf(8, 3, 5, 2, 4, 6, 0, 1))}")

}
/*
    We are given an array containing ‘n’ distinct numbers taken from the range 0 to ‘n’.
    Since the array has only ‘n’ numbers out of the total ‘n+1’ numbers, find the missing number.
 */
fun findMissingNumber(list: MutableList<Int>): Int {
    var index = 0
    val size = list.size
    while(index < size) {
        val num = list[index]
        if(num < size && num != index) {
            //swap
            list[index] = list[num]
            list[num] = num
        } else {
            index++
        }
    }

    for(i in list.indices) {
        if(i != list[i]) return i
    }
    return size
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