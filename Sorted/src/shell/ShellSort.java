package shell;

import util.Student;

import static util.SortTestHelper.*;

/**
 * 希尔排序
 * 算法思想就是按步长的插入排序，然后步长逐渐增加
 * 不稳定
 *
 */
public class ShellSort {

    private static void shellSort(Comparable[] arr) {
        int n = arr.length;
        int h = 1;
        while (h < n/3) h = 3 * h + 1; //步长从N/3递减至1，现在算出最大值。
        while (h >= 1) {
            for (int i = h; i < n; i++) {
                for (int j = i; j >= h && less(arr[j], arr[j - h]) ; j -= h) {
                    swap(arr, j, j - h);
                }
            }
            h /= 3;
        }
    }

    public static void main(String[] args) {
        Integer[] arr = generateArray(100, 0, 100);

        Student s1 = new Student("AA", 99);
        Student s2 = new Student("BB", 98);

        Student[] stuList = new Student[]{s1, s2};
        shellSort(arr);
        assert isSorted(arr);
        print(arr);
    }


}
