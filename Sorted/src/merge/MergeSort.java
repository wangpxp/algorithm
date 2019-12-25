package merge;

import util.SortTestHelper;
import util.Student;

import static insertion.InsertionSort.insertionSort;
import static util.SortTestHelper.*;

/**
 * 归并排序
 * 算法思想，将数组不断二分，最后申请一个空间用O(N)的复杂度将两个有序数组排好序
 * 时间复杂度O(NlogN)
 * 稳定
 */
public class MergeSort<T> {

    private static Comparable[] aux;

    // 这种写法是将aux定义成arr一样大小，操作起来比较方便，因为指针都一样
    private static void merge(Comparable[] arr, int lo, int mid, int hi) {
        int i = lo, j = mid + 1; // 左右数组开始指针
        for (int k = lo; k <= hi; k++) { // 左闭右闭！！
            aux[k] = arr[k]; //将arr复制一份，以便原地归并
        }
        for (int k = lo; k <= hi; k++) { //遍历一遍arr的小数组，将arr[lo,mid]和arr[mid+1,hi]归并
            if (i > mid) arr[k] = aux[j++];
            else if (j > hi) arr[k] = aux[i++];
            else if (less(aux[j], aux[i])) arr[k] = aux[j++];
            else arr[k] = aux[i++];
        }
    }

    // 这种写法是每次都创建和arr小数组，即hi-lo+1大小的数组，指针操作比较复杂
    // 完全没必要这么做，忘掉这种方法就好，直接生成和整个arr等大的数组
    private static void mergeAnother(Comparable[] arr, int lo, int mid, int hi) {
        Comparable[] auxTemp = new Comparable[hi - lo + 1];
        int i = lo, j = mid + 1; // 左右数组开始指针
        for (int k = lo; k <= hi; k++) { // 左闭右闭！！
            auxTemp[k - lo] = arr[k]; //arr是从lo开始，但是auxTemp是从0开始
        }
        for (int k = lo; k <= hi; k++) { //遍历一遍arr的小数组，将arr[lo,mid]和arr[mid+1,hi]归并
            if (i > mid) {
                arr[k] = auxTemp[j - lo];
                j++;
            } else if (j > hi) {
                arr[k] = auxTemp[i - lo];
                i++;
            } else if (less(auxTemp[j - lo], auxTemp[i - lo])) {
                arr[k] = auxTemp[j - lo];
                j++;
            } else {
                arr[k] = auxTemp[i - lo];
                i++;
            }
        }
    }

    private static void mergeSort(Comparable[] arr) {
        aux = new Comparable[arr.length];
        mergeSort(arr, 0, arr.length - 1);  //左闭右闭的指针，边界定义很重要
    }

    private static void mergeSort(Comparable[] arr, int lo, int hi) {
        //if (lo >= hi) return; // 递归终止条件

        if (hi - lo <= 15) { //归并排序优化，在数据量小的时候用插入排序
            insertionSort(arr, lo, hi);
            return;
        }

        int mid = lo + (hi - lo) / 2;
        mergeSort(arr, lo, mid);
        mergeSort(arr, mid + 1, hi); //将数组二分
        if (less(arr[mid + 1], arr[mid])) // 归并排序的近乎有序数组的优化，仅当arr[mid]>arr[mid+1]才进行归并
            merge(arr, lo, mid, hi); //原地归并，即借助三个指针将arr看作很多小数组，对这些小数组实现相同的归并操作
    }

    // 自底向上的归并排序，使用的是循环，可以对链表使用
    private static void mergeSortBU(Comparable[] arr) {
        int n = arr.length;
        aux = new Comparable[n];
        for (int sz = 1; sz < n; sz += sz) { // 每次归并的大小
            for (int i = 0; i + sz < n; i += sz + sz) { //每次对两倍sz大小归并
                merge(arr, i, i + sz - 1, Math.min(i + sz + sz - 1, n - 1));
            }
        }
    }

    public static void main(String[] args) {
        Integer[] arr = generateArray(100, 0, 100);

        Student s1 = new Student("AA", 99);
        Student s2 = new Student("BB", 98);

        Student[] stuList = new Student[]{s1, s2};
        mergeSortBU(arr);
        assert isSorted(arr);
        print(arr);
    }

}
