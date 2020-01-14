package dp;

public class _53_MaximumSubarray {

    public static int maxSubArray(int[] nums) {
        int res = Integer.MIN_VALUE;
        int sum = 0;
        for (int num : nums) {
            if (sum > 0) sum += num;
            else sum = num;
            if (sum > res) res = sum;
        }
        return res;
    }
}
