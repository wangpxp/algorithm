package util;

import java.util.Random;

public class SortTestHelper {

    //生成一个随机的整数数组
    public static Integer[] generateArray(int n, int rangeL, int rangeR) {
        assert rangeL <= rangeR;
        Integer[] arr = new Integer[n];
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            arr[i] = rand.nextInt(rangeR - rangeL + 1) + rangeL;
        }
        return arr;
    }

    //可以打印所有类型的数组
    public static <T> void print(T[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    // 小于
    public static <T extends Comparable> boolean less(T v, T w) {
        return v.compareTo(w) < 0;
    }

    // 交换
    public static <T> void swap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // 是否排序成功
    public static <T extends Comparable> boolean isSorted(T[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (less(arr[i], arr[i - 1])) return false;
        }
        return true;
    }


}