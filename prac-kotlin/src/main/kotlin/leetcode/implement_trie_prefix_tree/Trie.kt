package leetcode.implement_trie_prefix_tree

class TrieNode {
    var leafNode: Boolean = false
    val children: Array<TrieNode?> = arrayOfNulls(26)
}

// https://leetcode.com/problems/implement-trie-prefix-tree/
class Trie() {
    private var root = TrieNode()

    fun insert(word: String) {
        var currentNode = root
        for (c in word) {
            if (currentNode.children[c - 'a'] == null) {
                currentNode.children[c - 'a'] = TrieNode()
            }
            currentNode = currentNode.children[c - 'a']!!
        }
        currentNode.leafNode = true
    }

    fun search(word: String): Boolean {
        var currentNode = root
        for (c in word) {
            if (currentNode.children[c - 'a'] == null) {
                return false
            }
            currentNode = currentNode.children[c - 'a']!!
        }
        return currentNode.leafNode
    }

    fun startsWith(prefix: String): Boolean {
        var currentNode = root
        for (c in prefix) {
            if (currentNode.children[c - 'a'] == null) {
                return false
            }
            currentNode = currentNode.children[c - 'a']!!
        }
        return true
    }

}