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
            for(int i = 0;i<nums.length;i++){
                nums[i]+= nums[i-1];
            }
        }

        /* Time complexity will be O(1) - because all the sum is calculated when its initialized.
         */
        public int sumRange(int left, int right) {
            /*
            if condition stmt is slower than ternary operator.
             */
            /*if(left == 0)
                return nums[right];*/
            int lsum = left-1 < 0 ? 0 : nums[left-1];
            return nums[right]-lsum;
        }
    }
}
