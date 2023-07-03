package arrays;

/**
 *  Given an array of integers nums, calculate the pivot index of this array.
 *
 * The pivot index is the index where the sum of all the numbers strictly to the left of the index is equal to the sum of all the numbers strictly to the index's right.
 *
 * If the index is on the left edge of the array, then the left sum is 0 because there are no elements to the left. This also applies to the right edge of the array.
 *
 * Return the leftmost pivot index. If no such index exists, return -1.
 *
 * Link : https://leetcode.com/problems/find-pivot-index/description
 */
public class PivotIndex {

    public static void main(String[] args) {
        pivotIndex(new int[]{1,7,3,6,5,6});
    }

    /* O(n) complexity */
    public static int pivotIndex(int[] nums) {
        int sum = 0;
        for(int i=0;i<nums.length;i++)
            sum+=nums[i];
        int lsum=0;
        for(int i=0;i<nums.length;i++){
            sum-=nums[i];
            if(lsum==sum)
                return i;
            else
                lsum+=nums[i];
        }
        return -1;
    }

    /* Initial solution with O(n^2) time complexity */
    public static int pivotIndexInitial(int[] nums) {
        for(int i=0;i<nums.length;i++){
            int lsum = 0,rsum = 0;
            for(int j=0;j<i;j++)
                lsum+=nums[j];
            for(int k=i+1;k<nums.length;k++)
                rsum+=nums[k];
            if(lsum==rsum)
                return i;
        }
        return -1;
    }
}
