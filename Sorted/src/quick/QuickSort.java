package quick;

import util.Student;

import java.util.Random;

import static util.SortTestHelper.*;

/**
 * 快速排序
 * 算法思想：选取一个基准点（通常是第一个），让它前面的元素都小于它，它后面的元素都大于它
 * 然后分别再对这两个部分进行插入排序
 * 杂乱无章的情况下速度最快的排序
 * 时间复杂度O(NlogN)，最差O(n^2)
 */
public class QuickSort {
    static Random random = new Random();

    private static void quickSort(Comparable[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(Comparable[] arr, int l, int r) {
        if (l >= r) return; //递归终止条件

        int p = partition_2(arr, l, r);
        quickSort(arr, l, p - 1);
        quickSort(arr, p + 1, r);
    }

    // 改进的partition算法，让数组前后两端同时进行工作，可以让有着大量重复元素下的排序更快
    // arr[l+1...i)<=v, arr(j...r]>=v
    private static int partition_2(Comparable[] arr, int l, int r) {
        swap(arr, l, random.nextInt(r - l + 1) + l);
        Comparable v = arr[l];
        int i = l + 1, j = r;
        while (true) {
            while (i <= r && less(arr[i], v)) i++; //i<=r可以省略，j>l也是
            while (j > l && less(v, arr[j])) j--;
            if (i >= j) break;
            swap(arr, i++, j--);
        }
        swap(arr, l, j);
        return j;
    }

    // 返回p,使得arr[l...p-1]<arr[p],arr[p+1...r]>arr[p]
    private static int partition(Comparable[] arr, int l, int r) {
        swap(arr, l, random.nextInt(r - l + 1) + l);
        Comparable v = arr[l]; // 通常选取数组第一个值作为基准点,但是如果数组近乎有序，效率会退化到O(N^2)

        int j = l; // 初始值要定义好
        // 对后面的数组遍历一遍, 使得arr[l+1..j]<v, arr[j...i] >v
        for (int i = l + 1; i <= r; i++) {
            if (less(arr[i], v)) swap(arr, ++j, i);
        }
        swap(arr, l, j);
        return j;
    }



    public static void main(String[] args) {
        Integer[] arr = generateArray(100, 0, 100);

        Student s1 = new Student("AA", 99);
        Student s2 = new Student("BB", 98);

        Student[] stuList = new Student[]{s1, s2};
        quickSort(arr);
        assert isSorted(arr);
        print(arr);
    }

}
