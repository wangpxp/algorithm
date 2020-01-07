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

    public int[][] merge(int[][] intervals) {
        quickSort(intervals);
        int i = 0;
        List<int[]> list = new ArrayList<>();
        while (i < intervals.length) {
            int left = intervals[i][0];
            int right = intervals[i][1];
            while (i < intervals.length - 1 && right >= intervals[i + 1][0]) {
                right = Math.max(right, intervals[i + 1][1]);
                i++;
            }
            list.add(new int[] {left, right});
            i++;
        }
        return list.toArray(new int[list.size()][2]);
    }

    private void quickSort(int[][] intervals) {
        quickSort(intervals, 0, intervals.length - 1);
    }

    private void quickSort(int[][] intervals, int l, int r) {
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
