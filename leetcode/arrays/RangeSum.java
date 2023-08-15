package arrays;

/**
 * Link: https://leetcode.com/problems/range-sum-query-immutable/description/
 */
public class RangeSum {

    public static void main(String[] args) {
        NumArray numArray = new NumArray(new int[]{-2, 0, 3, -5, 2, -1});
        numArray.sumRange(0, 2); // return (-2) + 0 + 3 = 1
        numArray.sumRange(2, 5); // return 3 + (-5) + 2 + (-1) = -1
        numArray.sumRange(0, 5); // return (-2) + 0 + 3 + (-5) + 2 + (-1) = -3
    }

    static class NumArray {

        private int[] nums;

        public NumArray(int[] nums) {
            this.nums = nums;
            int sum = 0;
            for(int i = 0;i<nums.length;i++){
                sum+=nums[i];
                nums[i] = sum;
            }
        }

        public int sumRange(int left, int right) {
            int lsum = left-1 < 0 ? 0 : nums[left-1];
            return nums[right]-lsum;
        }
    }
}
