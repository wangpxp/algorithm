package easyalgorithm;

public class _26_RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        int i = 1, p = 0;
        while (i < nums.length) {
            if (nums[i] != nums[p]) {
                p++;
                swap(nums, i, p);
            }
            i++;
        }
        return p + 1;
    }
    public void swap (int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
