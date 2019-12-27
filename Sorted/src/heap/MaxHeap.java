package heap;

import java.util.Random;

import static util.SortTestHelper.less;
import static util.SortTestHelper.swap;

public class MaxHeap {

    Comparable[] data;
    int count;

    MaxHeap(int capacity) {
        data = new Comparable[capacity + 1];
        count = 0;
    }

    int size() {return count;}

    boolean isEmpty() {
        return count == 0;
    }

    void insert(Comparable item) {
        data[++count] = item;
        swim(count); //插入后用上浮的方法重新调整为最大堆
    }

    private void swim(int k) {
        while (k > 1 && less(data[k / 2], data[k])) {
            swap(data, k, k / 2);
            k /= 2;
        }
    }

    void print() {
        for (int i = 1; i <= count; i++) {
            System.out.print(data[i] + " ");
        }
    }

    public static void main(String[] args) {
        MaxHeap maxHeap = new MaxHeap(100);
        System.out.println(maxHeap.size());

        Random random = new Random();
        for (int i = 0; i < 9; i++) {
            maxHeap.insert(random.nextInt(10));
        }
        maxHeap.print();
    }
}
