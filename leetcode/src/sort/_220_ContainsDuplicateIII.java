package sort;

import java.util.TreeSet;

/**
 * 给定一个整数数组，判断数组中是否有两个不同的索引 i 和 j，使得 nums [i] 和 nums [j] 的差的绝对值最大为 t，并且 i 和 j 之间的差的绝对值最大为 ķ。
 *
 * 示例 1:
 *
 * 输入: nums = [1,2,3,1], k = 3, t = 0
 * 输出: true
 * 示例 2:
 *
 * 输入: nums = [1,0,1,1], k = 1, t = 2
 * 输出: true
 * 示例 3:
 *
 * 输入: nums = [1,5,9,1,5,9], k = 2, t = 3
 * 输出: false
 */

public class _220_ContainsDuplicateIII {
    //滑动窗口查找表，将窗口设置成k大小
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            Long ceil = set.ceiling((long) nums[i] - t);
            if (ceil != null && ceil <= (long) nums[i] + t)
                return true;
            // 是当前这个数与窗口内的数字比较，所以要先比较完再添加
            set.add((long) nums[i]);
            if (set.size() > k)
                set.remove((long) nums[i - k]);
        }
        return false;
    }
}
