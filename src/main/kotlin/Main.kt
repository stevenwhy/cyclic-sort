import java.util.*

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

    println("Cyclic Sort #3 Find Missing Numbers -------------------")
    println("Input: [2, 3, 1, 8, 2, 3, 5, 1]\n" +
            "Output: 4, 6, 7\n" +
            "actual: ${findMissingNumbers(mutableListOf(2, 3, 1, 8, 2, 3, 5, 1))}")
    println("Input: [2, 4, 1, 2]\n" +
            "Output: 3\n" +
            "actual: ${findMissingNumbers(mutableListOf(2, 4, 1, 2))}")
    println("Input: [2, 3, 2, 1]\n" +
            "Output: 4\n" +
            "actual: ${findMissingNumbers(mutableListOf(2, 3, 2, 1))}")

    println("Cyclic Sort #4 Find Duplicate Number -------------------")
    println("Input: [1, 4, 4, 3, 2]\n" +
            "Output: 4\n" +
            "actual: ${findDuplicateNumber(mutableListOf(1, 4, 4, 3, 2))}")
    println("Input: [2, 1, 3, 3, 5, 4]\n" +
            "Output: 3\n" +
            "actual: ${findDuplicateNumber(mutableListOf(2, 1, 3, 3, 5, 4))}")
    println("Input: [2, 4, 1, 4, 4]\n" +
            "Output: 4\n" +
            "actual: ${findDuplicateNumber(mutableListOf(2, 4, 1, 4, 4))}")

}

/*
    Find that duplicate number without using any extra space.
 */
fun findDuplicateNumber(list: MutableList<Int>): Int {
    if(list.size <= 1) return 0

    var index = 0
    while(index < list.size) {
        val foundIndex = list[index]-1
        if(list[foundIndex] != list[index]) {
            Collections.swap(list,foundIndex,index)
        } else if(foundIndex != index) return list[index]
        else index++
    }
    return -1
}
/*
    We are given an unsorted array containing numbers taken from the range 1 to ‘n’.
    The array can have duplicates, which means some numbers will be missing. Find all those missing numbers.
 */
fun findMissingNumbers(list: MutableList<Int>): MutableList<Int> {
    if(list.size <= 1) return mutableListOf()
    // plan is to cyclic sort the list and then iterate again to see
    //   which indices satisfy list[index] != index
    var index = 0
    val result = mutableListOf<Int>()
    while(index < list.size) {
        val temp = list[index] // 2
        if(temp != index && list[index] != list[temp-1]) { // 2 != 0
            //swap
            list[index] = list[temp-1]
            list[temp-1] = temp
        } else {
            index++
        }
    }
    //check for missing
    for(i in list.indices) {
        if(list[i] != i+1) result.add(i+1)
    }
    return result
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