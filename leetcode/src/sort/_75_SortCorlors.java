package sort;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 *
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 *
 * 注意:
 * 不能使用代码库中的排序函数来解决这道题。
 *
 * 示例:
 *
 * 输入: [2,0,2,1,1,0]
 * 输出: [0,0,1,1,2,2]
 */


public class _75_SortCorlors {
    //思路：直接一遍扫描记录0 1 2的个数，直接输出
/*    public void sortColors(int[] nums) {
        int count_0 = 0, count_1 = 0, count_2 = 0;
        for (int num : nums) {
            if (num == 0) count_0++;
            else if(num == 1) count_1++;
            else count_2++;
        }
        for (int i = 0; i < count_0; i++) {
            nums[i] = 0;
        }
        for (int i = count_0; i < count_0 + count_1; i++) {
            nums[i] = 1;
        }
        for (int i = count_0 + count_1; i < nums.length; i++) {
            nums[i] = 2;
        }
    }*/

    //思路：三向切分快排，小于1放在左边，大于1放在右边
    public void sortColors(int[] nums) {
        int lt = 0, gt = nums.length - 1, i = 0;
        while (i <= gt) {
            if (nums[i] < 1) swap(nums, lt++, i++);
            else if (nums[i] > 1) swap(nums, gt--, i);
            else i++;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
