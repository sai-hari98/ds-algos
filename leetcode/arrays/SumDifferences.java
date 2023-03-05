package arrays;

/**
 * Given a 0-indexed integer array nums, find a 0-indexed integer array answer where:
 *
 * answer.length == nums.length.
 * answer[i] = |leftSum[i] - rightSum[i]|.
 * Where:
 *
 * leftSum[i] is the sum of elements to the left of the index i in the array nums. If there is no such element, leftSum[i] = 0.
 * rightSum[i] is the sum of elements to the right of the index i in the array nums. If there is no such element, rightSum[i] = 0.
 * Return the array answer.
 * Link: https://leetcode.com/problems/left-and-right-sum-differences/description/
 */

public class SumDifferences {
    public static void main(String[] args){
        int[] sumDiff = leftRightDifference(new int[]{10,4,8,3});
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[ ");
        for(int i=0;i<sumDiff.length;i++){
            stringBuilder.append(sumDiff[i]+" ");
        }
        stringBuilder.append("]");
        System.out.println("Sum Differences is: "+ stringBuilder.toString());
    }

    public static int[] leftRightDifference(int[] nums) {
        int total=0;
        for(int i=0;i<nums.length;i++)
            total+=nums[i];
        int leftTotal = 0;
        /**
         * Using the total and the left values passed through to find the left and the right sum.
         * After passing through an index, the value in it is not required anymore just the sum is needed.
         * So, the same array nums is used to optimize the space to O(1)
         */
        for(int i=0;i<nums.length;i++){
            int temp = nums[i];
            int rightTotal = total-temp-leftTotal;
            nums[i] = Math.abs(leftTotal-rightTotal);
            leftTotal+=temp;
        }
        return nums;
    }
}

