package leetcode.design_hashmap;

// https://leetcode.com/problems/design-hashmap/description/
class MyHashMap {

    static class Node {
        int key, val;
        Node next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    final Node[] nodes = new Node[20000];

    public MyHashMap() {

    }

    public void put(int key, int value) {
        int idx = key % nodes.length;
        if (nodes[idx] == null) {
            nodes[idx] = new Node(key, value);
            return;
        }

        Node node = nodes[idx];

        while (node != null) {
            if (node.key == key) {
                node.val = value;
                return;
            }
            if (node.next == null) break;

            node = node.next;
        }
        node.next = new Node(key, value);
    }

    public int get(int key) {
        int idx = key % nodes.length;

        if (nodes[idx] == null) return -1;

        Node node = nodes[idx];

        while (node != null) {
            if (node.key == key) return node.val;
            node = node.next;
        }

        return -1;
    }

    public void remove(int key) {
        int idx = key % nodes.length;
        if (nodes[idx] == null) return;

        Node node = nodes[idx];
        if (node.key == key) {
            if (node.next == null) nodes[idx] = null;
            else nodes[idx] = node.next;
            return;
        }

        Node prev = node;
        while (node != null) {
            if (node.key == key) {
                prev.next = node.next;
                return;
            }
            prev = node;
            node = node.next;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */