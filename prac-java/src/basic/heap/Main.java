package basic.heap;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        BinaryHeap binaryHeap = new BinaryHeap();
        binaryHeap.add(5);
        binaryHeap.add(4);
        binaryHeap.add(3);
        binaryHeap.add(6);
        binaryHeap.add(1);
        binaryHeap.add(2);

        Integer tmp = binaryHeap.pop();
        while (tmp != null) {
            System.out.println(tmp);
            tmp = binaryHeap.pop();
        }
    }
}

class BinaryHeap {

    private final List<Integer> elements;

    public BinaryHeap() {
        this.elements = new ArrayList<>();
        elements.add(null);
    }

    public BinaryHeap(int initSize) {
        this.elements = new ArrayList<>(initSize);
        elements.add(null);
    }

    public void add(int k) {
        elements.add(k);
        percolateUp();
    }

    public Integer pop() {
        if (elements.size() == 1) return null;
        Integer smallest = elements.get(1);
        elements.set(1, elements.get(elements.size() - 1));
        elements.remove(elements.size() - 1);
        percolateDown(1);
        return smallest;
    }

    private void swap(int i, int j) {
        Integer tmp = elements.get(i);
        elements.set(i, elements.get(j));
        elements.set(j, tmp);
    }

    private void percolateUp() {
        int currentIdx = elements.size() - 1;
        int parentIdx = currentIdx / 2;

        while (parentIdx > 0) {
            if (elements.get(currentIdx) < elements.get(parentIdx)) {
                swap(currentIdx, parentIdx);
            }
            else {
                // 부모가 더 작다면 더 이상 진행할 필요가 없음
                return;
            }
            currentIdx = parentIdx;
            parentIdx = currentIdx / 2;
        }
    }

    private void percolateDown(int i) {
        int left = i * 2;
        int right = left + 1;
        int smallest = i;

        if (left <= elements.size() - 1 && elements.get(left) < elements.get(smallest)) {
            smallest = left;
        }

        if (right <= elements.size() - 1 && elements.get(right) < elements.get(smallest)) {
            smallest = right;
        }

        if (smallest != i) {
            swap(smallest, i);
            percolateDown(smallest);
        }
    }

}