package leetcode.reorder_data_in_log_file


// https://leetcode.com/problems/reorder-data-in-log-files/

fun main() {
    val solution = Solution()
    val logs = arrayOf("dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero")
    val result = solution.reorderLogFiles(logs)
    result.forEach {
        println(it)
    }
}

class Solution {
    fun reorderLogFiles(logs: Array<String>): Array<String> {
        var letterLogs = mutableListOf<String>()
        var digitLogs = mutableListOf<String>()

        for (log in logs) {
            val firstContentChar = log.split(" ")[1][0]
            if (firstContentChar.isDigit()) {
                digitLogs.add(log)
            } else if (firstContentChar.isLetter()) {
                letterLogs.add(log)
            } else {
                throw RuntimeException("invalid input")
            }
        }

        letterLogs.sortWith(Comparator { s1: String, s2: String ->
            val s1x = s1.split(" ", limit = 2)
            val s2x = s2.split(" ", limit = 2)
            when (val compared = s1x[1].compareTo(s2x[1])) {
                0 -> s1x[0].compareTo(s2x[0])
                else -> compared
            }
        })

        letterLogs.addAll(digitLogs)
        return letterLogs.toTypedArray<String>()
    }
}