package selection;

import util.Student;
import static util.SortTestHelper.*;

/**
 * 选择排序
 *
 * 该算法不能提前终止，只能完整的扫描n^2遍数组，因此效率较低，不经常使用
 *
 * 算法思想是找到最小的放到最前面
 * 因为每一次最前面的已经排好序了，所以下一次循环从下一个开始
 * 时间复杂度(O(n^2))
 * 不稳定（5 8 5 2 9    5会和2交换，放在了后面）
 */
public class SelectionSort {

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

    public static void main(String[] args) {
        Integer[] arr = generateArray(100, 0, 100);

        Student s1 = new Student("AA", 99);
        Student s2 = new Student("BB", 98);

        Student[] stuList = new Student[]{s1, s2};
        selectionSort(stuList);
        assert isSorted(stuList);
        print(stuList);
    }
}
