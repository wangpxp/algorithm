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

    //第一种冒泡排序
    private static void bubbleSort(Integer[] arr) {
        for (int i = 0; i < arr.length; i++) {
            //print(arr);
            for (int j = i; j < arr.length; j++) {
                if (less(arr[j], arr[i]))
                    swap(arr, i, j);
            }
        }
    }

    private static void bubbleSort_1(Integer[] arr) {
        for (int i = 0; i < arr.length; i++) {
            //print(arr);
            for (int j = 0, k = 1; j < arr.length - 1; j++, k++) {
                if (less(arr[k], arr[j]))
                    swap(arr, j, k);
            }
        }
    }

    public static void main(String[] args) {
        Integer[] arr = generateArray(20000, 0, 10000);
        Student s1 = new Student("AA", 99);
        Student s2 = new Student("BB", 98);

        Student[] stuList = new Student[]{s1, s2};

        long startTime1 =  System.currentTimeMillis();
        bubbleSort(arr);
        long endTime1 =  System.currentTimeMillis();
        long usedTime1 = (endTime1-startTime1);
        System.out.println();

        long startTime2 =  System.currentTimeMillis();
        bubbleSort_1(arr);
        long endTime2 =  System.currentTimeMillis();
        long usedTime2 = (endTime2-startTime2);
        System.out.println(usedTime1);
        System.out.println(usedTime2);
        assert isSorted(arr);
        //print(arr);
    }

}
