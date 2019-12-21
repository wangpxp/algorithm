package selection;

import static util.SortTestHelper.*;

public class SelectionSort {
    public static void main(String[] args) {
        Integer[] arr = generateArray(100, 0, 100);
        selectionSort(arr);
        print(arr);
    }


    /**
     * 算法思想是找到最小的放到最前面
     * 因为每一次最前面的已经排好序了，所以下一次循环从下一个开始
     * 时间复杂度(O(n^2))
     * 不稳定（5 8 5 2 9    5会和2交换，放在了后面）
     */

    private static<T extends Comparable> void selectionSort(T[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {  //找到i后面最小的数
                if (less(arr[j], arr[minIndex]))  //如果arr[j]小于arr[minIndex]，即让arr[minIndex]最小
                    minIndex = j;
            }
            swap(arr, i, minIndex);
        }
    }
}
