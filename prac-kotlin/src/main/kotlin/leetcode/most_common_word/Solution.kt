package leetcode.most_common_word

// https://leetcode.com/problems/most-common-word/
fun main() {
    val solution = Solution()
    val paragraph = "..Bob hit a ball, the hit BALL flew far after it was hit."
    val banned = arrayOf("hit")
    val result = solution.mostCommonWord(paragraph, banned)
    println(result)
}

class Solution {
    fun mostCommonWord(paragraph: String, banned: Array<String>): String {
        val words = convertParagraphToWords(paragraph)
        val bannedWords: Set<String> = banned.toSet()
        val counts = mutableMapOf<String, Int>()

        for (word in words) {
            if (!bannedWords.contains(word)) {
                counts[word] = counts.getOrDefault(word, 0) + 1
            }
        }
        return counts.maxBy { it.value }.key
    }

    private fun convertParagraphToWords(paragraph: String): List<String> {
        return paragraph.replace("\\W+".toRegex(), " ").trim().toLowerCase().split(" ")
    }
}