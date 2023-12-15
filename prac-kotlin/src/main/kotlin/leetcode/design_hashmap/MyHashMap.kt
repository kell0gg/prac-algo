package leetcode.design_hashmap

// https://leetcode.com/problems/design-hashmap/description/
class MyHashMap() {

    class Node(var key: Int, var `val`: Int) {
        var next: Node? = null
    }

    private val nodes: Array<Node?> = arrayOfNulls(20000)

    private fun getIdx(key: Int): Int {
        return key % nodes.size;
    }

    fun put(key: Int, value: Int) {
        val idx = getIdx(key)
        if (nodes[idx] == null) {
            nodes[idx] = Node(key, value)
            return
        }

        var node = nodes[idx]

        while (node != null) {
            if (node.key == key) {
                node.`val` = value
                return
            }
            if (node.next == null) break
            node = node.next
        }
        node!!.next = Node(key, value)
    }

    fun get(key: Int): Int {
        val idx = getIdx(key)

        if (nodes[idx] == null) return -1

        var node = nodes[idx]

        while (node != null) {
            if (node.key == key) return node.`val`
            node = node.next
        }
        return -1
    }

    fun remove(key: Int) {
        val idx = getIdx(key)

        if (nodes[idx] == null) return

        var node = nodes[idx]

        if (node!!.key == key) {
            if (node.next == null) nodes[idx] = null
            else nodes[idx] = node.next
            return
        }

        var prev = node
        while (node != null) {
            if (node.key == key) {
                prev!!.next = node.next
                return
            }
            prev = node
            node = node.next
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * var obj = MyHashMap()
 * obj.put(key,value)
 * var param_2 = obj.get(key)
 * obj.remove(key)
 */