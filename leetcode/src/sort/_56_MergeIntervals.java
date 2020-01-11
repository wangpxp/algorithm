package sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 给出一个区间的集合，请合并所有重叠的区间。
 *
 * 示例 1:
 *
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2:
 *
 * 输入: [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 */

public class _56_MergeIntervals {

    Random random = new Random();

    int[][] aux;

    public int[][] merge(int[][] intervals) {
        //quickSort3Ways(intervals);
        //quickSort(intervals);
        //mergeSort(intervals);
        //mergeSortNR(intervals);
        shellSort(intervals);
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int left = intervals[i][0];
            int right = intervals[i][1];
            while (i < intervals.length - 1 && right >= intervals[i + 1][0]) { // 先写i判定
                right = Math.max(right, intervals[i + 1][1]);
                i++;
            }
            list.add(new int[]{left, right});
        }
        return list.toArray(new int[list.size()][2]);
    }

    private void shellSort(int[][] intervals) {
        int n = intervals.length;
        int h = 1;
        while (h < n/3) h = 3*h + 1; //算出步长最大值，每次递减
        while (h >= 1) {
            for (int i = h; i < n; i++) {
                int[] temp = intervals[i];
                int j;
                for (j = i; j >= h && less(temp, intervals[j - h]); j -= h) { //步长表现在j上，和前h个元素比较并交换
                    intervals[j] = intervals[j - h];
                }
                intervals[j] = temp;
            }
            h /= 3;
        }
    }

    private void mergeSortNR(int[][] intervals) {
        int n = intervals.length;
        aux = new int[intervals.length][2];
        for (int sz = 1; sz < n; sz += sz) { // 步长
            for (int i = 0; i + sz < n; i += sz + sz) { //每次一组进行操作
                merge(intervals, i, i + sz - 1, Math.min(i + sz + sz - 1, n - 1));
            }
        }
    }

    private void mergeSort(int[][] intervals) {
        aux = new int[intervals.length][2];
        mergeSort(intervals, 0, intervals.length - 1);
    }

    private void mergeSort(int[][] intervals, int l, int r) {
        if (l >= r) return;
        int mid = l + (r - l) / 2;
        mergeSort(intervals, l, mid);
        mergeSort(intervals, mid + 1, r);
        if (less(intervals[mid + 1], intervals[mid]))
            merge(intervals, l, mid, r);
    }

    private void merge(int[][] intervals, int l, int mid, int r) {
        int i = l, j = mid + 1;
        for (int k = l; k <= r; k++) {
            aux[k] = intervals[k];
        }
        for (int k = l; k <= r; k++) {
            if (i > mid) intervals[k] = aux[j++];
            else if (j > r) intervals[k] = aux[i++];
            else if (less(aux[i], aux[j])) intervals[k] = aux[i++];
            else intervals[k] = aux[j++];
        }
    }

    private void quickSort(int[][] intervals) {
        quickSort(intervals, 0, intervals.length - 1);
    }

    private void quickSort(int[][] intervals, int l, int r) {
        if (l >= r) return;
        int p = partition(intervals, l, r);
        quickSort(intervals, l, p - 1);
        quickSort(intervals,p + 1, r);
    }

    private int partition(int[][] intervals, int l, int r) {
        swap(intervals, l, random.nextInt(r - l + 1) + l);
        int[] v = intervals[l];
        int i = l + 1, j = r;
        while (true) {
            while (i <= r && less(intervals[i], v)) i++;
            while (j > l && less(v, intervals[j])) j--;
            if (i >= j) break;
            swap(intervals, i++, j--);
        }
        swap(intervals, l, j);
        return j;
    }

    private void quickSort3Ways(int[][] intervals) {
        quickSort3Ways(intervals, 0, intervals.length - 1);
    }

    private void quickSort3Ways(int[][] intervals, int l, int r) {
        if (r <= l) return; // 递归终止条件，在小于一定程度时可以使用插入排序
        // 因为可能又大量相同的元素，这里采用三向切分
        swap(intervals, l, random.nextInt(r - l + 1) + l);
        int[] temp = intervals[l];
        int lt = l, gt = r, i = l + 1;
        while(i <= gt) {
            if (less(intervals[i], temp)) swap(intervals, lt++, i++);
            else if(less(temp, intervals[i])) swap(intervals, gt--, i);
            else i++;
        }
        quickSort(intervals, l, lt - 1);
        quickSort(intervals, gt + 1, r);
    }

    private boolean less(int[] interval, int[] temp) {
        if (interval[0] < temp[0]) return true;
        return false;
    }

    private void swap(int[][] intervals, int i, int j) {
        int[] temp = intervals[i];
        intervals[i] = intervals[j];
        intervals[j] = temp;
    }
}
