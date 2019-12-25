package bubble;

import util.Student;

import static util.SortTestHelper.*;

/**
 * 冒泡排序
 * 算法思想：重复地走访过要排序的元素列，依次比较两个相邻的元素，如果顺序（如从大到小、首字母从从Z到A）错误就把他们交换过来
 * 时间复杂度O(n^2)
 * 稳定
 */
public class BubbleSort {

    //基于比较的选择排序（很多无意义的交换，不推荐使用）
    private static void selectionSort(Comparable[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if (less(arr[j], arr[i]))
                    swap(arr, i, j);
            }
        }
    }


    //未优化冒泡排序
    private static void bubbleSort_1(Comparable[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if(less(arr[j + 1], arr[j]))
                    swap(arr, j, j + 1);
            }
        }
    }

/*    private static void bubbleSort_1(Comparable[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = arr.length - 1; j > i; j--) {
                if(less(arr[j], arr[j - 1]))
                    swap(arr, j, j - 1);
            }
        }
    }*/

    // 优化的冒泡排序
    // 由于冒泡排序每一次都会交换数据，当有一轮没有交换数据时，说明已经排好序，不需要再继续循环了。
    // 优化的是外层循环
    private static void bubbleSort_2(Comparable[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            boolean flag = false;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if(less(arr[j + 1], arr[j])) {
                    swap(arr, j, j + 1);
                    flag = true;
                }
            }
            if(flag == false) break;
        }
    }

    public static void main(String[] args) {
        Integer[] arr = generateArray(10, 0, 100);
        Student s1 = new Student("AA", 99);
        Student s2 = new Student("BB", 98);

        Student[] stuList = new Student[]{s1, s2};

        //bubbleSort_1(arr);
        bubbleSort_2(arr);
        assert isSorted(arr);
        print(arr);
    }

}
