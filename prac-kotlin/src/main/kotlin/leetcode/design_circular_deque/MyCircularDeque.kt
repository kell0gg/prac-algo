package leetcode.design_circular_deque

// https://leetcode.com/problems/design-circular-deque/description/
class MyCircularDeque(k: Int) {
    class DoubleLinkedList(val `val`: Int) {
        var left: DoubleLinkedList? = null
        var right: DoubleLinkedList? = null
    }

    var head: DoubleLinkedList? = null
    var tail: DoubleLinkedList? = null
    var k = 0
    var size = 0

    init {
        head = DoubleLinkedList(0)
        tail = DoubleLinkedList(0)

        head!!.right = tail
        tail!!.left = head
        this.k = k
    }

    fun insertFront(value: Int): Boolean {
        if (isFull()) return false
        val node = DoubleLinkedList(value)
        node.right = head!!.right
        node.left = head
        head!!.right!!.left = node
        head!!.right = node
        size++
        return true
    }

    fun insertLast(value: Int): Boolean {
        if (isFull()) return false
        val node = DoubleLinkedList(value)
        node.left = tail!!.left
        node.right = tail
        tail!!.left!!.right = node
        tail!!.left = node
        size++
        return true
    }

    fun deleteFront(): Boolean {
        if (isEmpty()) return false
        head!!.right!!.right!!.left = head
        head!!.right = head!!.right!!.right
        size--
        return true
    }

    fun deleteLast(): Boolean {
        if (isEmpty()) return false
        tail!!.left!!.left!!.right = tail
        tail!!.left = tail!!.left!!.left
        size--
        return true
    }

    fun getFront(): Int {
        return if (isEmpty()) -1 else head!!.right!!.`val`
    }

    fun getRear(): Int {
        return if (isEmpty()) -1 else tail!!.left!!.`val`
    }

    fun isEmpty(): Boolean {
        return size == 0

    }

    fun isFull(): Boolean {
        return size == k
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * var obj = MyCircularDeque(k)
 * var param_1 = obj.insertFront(value)
 * var param_2 = obj.insertLast(value)
 * var param_3 = obj.deleteFront()
 * var param_4 = obj.deleteLast()
 * var param_5 = obj.getFront()
 * var param_6 = obj.getRear()
 * var param_7 = obj.isEmpty()
 * var param_8 = obj.isFull()
 */