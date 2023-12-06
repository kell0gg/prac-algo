package leetcode.design_circular_queue


class MyCircularQueue(k: Int) {
    val q: IntArray = IntArray(k)
    var front = 0
    var rear = -1
    var size = 0

    fun enQueue(value: Int): Boolean {
        return if (this.isFull()) false
        else {
            this.rear = (this.rear + 1) % q.size
            this.q[rear] = value
            size++
            true
        }
    }

    fun deQueue(): Boolean {
        return if (this.isEmpty()) false
        else {
            this.front = (this.front + 1) % q.size
            size--
            true
        }
    }

    fun Front(): Int {
        if (isEmpty()) {
            return -1
        } else return q[this.front]
    }

    fun Rear(): Int {
        return if (isEmpty()) -1
        else q[this.rear]
    }

    fun isEmpty(): Boolean {
        return this.size == 0
    }

    fun isFull(): Boolean {
        return this.size == q.size
    }

}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * var obj = MyCircularQueue(k)
 * var param_1 = obj.enQueue(value)
 * var param_2 = obj.deQueue()
 * var param_3 = obj.Front()
 * var param_4 = obj.Rear()
 * var param_5 = obj.isEmpty()
 * var param_6 = obj.isFull()
 */