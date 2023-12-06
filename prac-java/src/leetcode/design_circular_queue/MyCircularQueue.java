package leetcode.design_circular_queue;

// https://leetcode.com/problems/design-circular-queue/
class MyCircularQueue {
    int[] q;
    int front = 0, rear = -1, size = 0;

    public MyCircularQueue(int k) {
        this.q = new int[k];
    }

    public boolean enQueue(int value) {
        if (this.isFull()) return false;
        else {
            this.rear = (this.rear + 1) % this.q.length;
            this.q[rear] = value;
            this.size++;
            return true;
        }
    }

    public boolean deQueue() {
        if (this.isEmpty()) return false;
        else {
            this.front = (this.front + 1) % this.q.length;
            this.size--;
            return true;
        }
    }

    public int Front() {
        if (isEmpty()) return -1;
        else return q[this.front];
    }

    public int Rear() {
        if (isEmpty()) return -1;
        else return q[this.rear];
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public boolean isFull() {
        return this.size == this.q.length;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */