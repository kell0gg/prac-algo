package leetcode.design_circular_deque;

// https://leetcode.com/problems/design-circular-deque/description/
class MyCircularDeque {
    static class DoublyLinkedList {
        DoublyLinkedList left;
        DoublyLinkedList right;
        int val;

        public DoublyLinkedList(int val) {
            this.val = val;
        }
    }

    int size;
    int k;
    DoublyLinkedList head;
    DoublyLinkedList tail;

    public MyCircularDeque(int k) {
        head = new DoublyLinkedList(0);
        tail = new DoublyLinkedList(0);
        head.right = tail;
        tail.left = head;
        this.k = k;
        this.size = 0;
    }

    public boolean insertFront(int value) {
        if (isFull()) return false;
        DoublyLinkedList node = new DoublyLinkedList(value);
        node.right = this.head.right;
        node.left = this.head;
        this.head.right.left = node;
        head.right = node;
        this.size++;
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()) return false;
        DoublyLinkedList node = new DoublyLinkedList(value);
        node.left = this.tail.left;
        node.right = this.tail;
        this.tail.left.right = node;
        this.tail.left = node;
        this.size++;
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) return false;
        this.head.right.right.left = this.head;
        this.head.right = this.head.right.right;
        this.size--;
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) return false;
        this.tail.left.left.right = this.tail;
        this.tail.left = this.tail.left.left;
        this.size--;
        return true;
    }

    public int getFront() {
        if (isEmpty()) return -1;
        else {
            return this.head.right.val;
        }
    }

    public int getRear() {
        if (isEmpty()) return -1;
        else {
            return this.tail.left.val;
        }
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public boolean isFull() {
        return this.size == k;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
