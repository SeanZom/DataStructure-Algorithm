/**
 *
 *  Algorithm - Data processing
 *
 *      Int array as parameter, a specific String as outcome
 *
 *      println(stringFormatter(intArrayOf(1, 3, 4, 5, 7, 8)))       // out: 1, 3-5, 7-8
 *      println(stringFormatter(intArrayOf(1, 2, 3, 6, 9, 12, 13)))  // out: 1-3, 6, 9, 12-13
 *      println(stringFormatter(intArrayOf(1, 2, 3, 5, 7, 9)))       // out: 1-3, 5, 7, 9
 *
 *
 *
 *
 */

fun main(args: Array<String>) {

    println(stringFormatter(intArrayOf(1, 3, 4, 5, 7, 8)))
    println(stringFormatter(intArrayOf(1, 2, 3, 6, 9, 12, 13)))
    println(stringFormatter(intArrayOf(1, 2, 3, 5, 7, 9)))
}

fun stringFormatter(numbers: IntArray): String {

    var result = ""

    if (numbers.isNotEmpty()) {

        val arr2 = mutableListOf<Int>()

        for (i in numbers.indices) {
            if (arr2.isEmpty() || numbers[i] == arr2.last() + 1) {
                arr2.add(numbers[i])
            } else {
                if (arr2.size > 1) {
                    result += "${arr2.first()}-${arr2.last()}"
                    if (i != numbers.lastIndex)
                        result += ", "
                } else {
                    result += arr2.joinToString(
                        postfix = if (i != numbers.lastIndex)
                            ", "
                        else
                            "")
                }
                arr2.clear()
                arr2.add(numbers[i])
            }

            if (i == numbers.lastIndex) {
                result += if (arr2.size > 1)
                    "${arr2.first()}-${numbers.last()}"
                else
                    ", ${numbers.last()}"
            }
        }
    }
    return result
}

fun arrayFormatterSolution2(numbers: IntArray): String? {

    if (numbers.isEmpty()) return null

    var result = ""
    var start = numbers[0]
    var end = start

    for (i in 1..(numbers.lastIndex)) {
        if (numbers[i] == numbers[i - 1] + 1) {
            end = numbers[i]
        } else {
            if (start == end) {
                result += "$start"
            } else {
                result += "$start-$end"
            }
            result += ", "
            start = numbers[i]
            end = numbers[i]
        }

        if (i == numbers.lastIndex) {
            if (start == end) {
                result += "$start"
            } else {
                result += "$start-$end"
            }
        }
    }

    return result
}

