package leetcode.serialize_and_deserialize_binary_tree

import java.util.Deque
import java.util.ArrayDeque

// https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
class Codec() {
    companion object {
        private const val END_OF_LEAF = "#"
        private const val DELIMITER = ","
    }

    // Encodes a URL to a shortened URL.
    fun serialize(root: TreeNode?): String {
        if(root == null) return END_OF_LEAF
        val stringBuilder = StringBuilder()
        val deque: Deque<TreeNode> = ArrayDeque()
        stringBuilder.append(root.`val`)
        stringBuilder.append(DELIMITER)
        deque.addLast(root)
        while (!deque.isEmpty()) {
            val current = deque.pollFirst()
            stringBuilder.append(convertVal(current.left))
            stringBuilder.append(DELIMITER)
            stringBuilder.append(convertVal(current.right))
            stringBuilder.append(DELIMITER)
            if (current.left != null) {
                deque.addLast(current.left)
            }
            if (current.right != null) {
                deque.addLast(current.right)
            }
        }

        return stringBuilder.substring(0, stringBuilder.length - 1)
    }

    // Decodes your encoded data to tree.
    fun deserialize(data: String): TreeNode? {
        if (data == END_OF_LEAF) return null

        val nodes = data.split(DELIMITER.toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
        var childIdx = 1
        val deque: Deque<TreeNode?> = ArrayDeque()
        val root = TreeNode(nodes[0].toInt())
        deque.addLast(root)
        while (!deque.isEmpty()) {
            val current = deque.pollFirst()
            // left
            if (nodes[childIdx] != END_OF_LEAF) {
                current!!.left = TreeNode(nodes[childIdx].toInt())
                deque.addLast(current.left)
            }
            childIdx++
            // right
            if (nodes[childIdx] != END_OF_LEAF) {
                current!!.right = TreeNode(nodes[childIdx].toInt())
                deque.addLast(current.right)
            }
            childIdx++
        }
        return root
    }

    private fun convertVal(node: TreeNode?): String {
        return node?.`val`?.toString() ?: END_OF_LEAF
    }
}

/**
 * Your Codec object will be instantiated and called as such:
 * var ser = Codec()
 * var deser = Codec()
 * var data = ser.serialize(longUrl)
 * var ans = deser.deserialize(data)
 */