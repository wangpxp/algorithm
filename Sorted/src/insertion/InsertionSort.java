package insertion;

import util.Student;

import static util.SortTestHelper.*;

/**
 * 插入排序
 *
 * 该算法可以优化，提前中断循环，还可以用二分法查找优化
 * 对于近乎排好序的数组来说，效率很高，因此经常使用
 *
 * 算法思想像拿扑克牌，将下一个数放在应该在的位置上
 * 时间复杂度(O(n^2))
 * 稳定
 */
public class InsertionSort {

    // 第一种插入排序，通过不断交换将数字放在应该在的位置上，因为交换效率很低，不推荐使用
    // j从第i个位置不断往前面交换，与第j-1位置的数字比较
    public static void insertionSort_1(Comparable[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j > 0 && less(arr[j], arr[j - 1]); j--) {
                swap(arr, j, j - 1);
            }
        }
    }


    // 第二种插入排序，直接找到arr[i]应该所在的位置，之后将j后面的数字都往后移一位，最后在那个位置赋值
    // 效率要比第一种高很多，也比选择排序好，因为可以提前内层中断循环
    // 在近乎排好序的数组里几乎是最快的算法
    public static void insertionSort_2(Comparable[] arr) {
        for (int i = 0; i < arr.length; i++) {
            //查找arr[i]应该插入的位置
            Comparable e = arr[i];
            int j; // 保存arr[i]插入的位置
            for (j = i; j > 0 && less(e, arr[j - 1]) ; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = e;
        }
    }

    // 第三种插入排序,由于前面已经是有序数组，所以用二分法找到arr[i]需要插入的位置
    // 由于使用了二分法，时间复杂度降低到了O(nlogn),但是失去了排几乎已经排好序的数组最快的特性
    // 因此使用也不是很多，不如快排有优势
    // 二分法的难点是没有那个点，找到返回条件
    public static void insertionSort_3(Comparable[] arr) {
        for (int i = 0; i < arr.length; i++) {
            // 用二分法查找arr[i]应该插入的位置
            Comparable e = arr[i];
            //int j = binarySearch(int)
        }
    }

    public static void insertionSort(Comparable[] arr, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++) {
            Comparable e = arr[i];
            int j;
            for (j = i; j > 0 && less(e, arr[j - 1]); j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = e;
        }
    }

    public static void main(String[] args) {
        Integer[] arr = generateArray(100, 0, 100);

        Student s1 = new Student("AA", 99);
        Student s2 = new Student("BB", 98);

        Student[] stuList = new Student[]{s1, s2};
        insertionSort_2(arr);
        assert isSorted(arr);
        print(arr);
    }
}
