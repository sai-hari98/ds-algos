package arrays;

/**
 * Given an integer array nums and an integer val, remove all occurrences of val in nums in-place. The order of the elements may be changed. Then return the number of elements in nums which are not equal to val.
 *
 * Consider the number of elements in nums which are not equal to val be k, to get accepted, you need to do the following things:
 *
 * Change the array nums such that the first k elements of nums contain the elements which are not equal to val. The remaining elements of nums are not important as well as the size of nums.
 * Return k.
 *
 * Problem Link: https://leetcode.com/problems/remove-element/description
 */
public class RemoveElement {

    public static void main(String[] args) {
        new RemoveElement().removeElement(new int[]{0,1,2,2,3,0,4,2}, 2);
    }

    public int removeElement(int[] nums, int val) {
        int i=0,j=0;
        for(;j < nums.length;j++){
            if(nums[j]!=val){
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }

    /* My failed attempt to solve the problem */
    public int removeElementFailed(int[] nums, int val) {
        int i=0,j=1;
        if(nums.length == 1)
            return nums[0] == val ? 0 : 1;
        for(;j < nums.length;j++){
            if(nums[i]!=val){
                i++;
            }

            if(nums[i] == val && nums[j] != val){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j = i;
            }

            j++;
        }
        return i;
    }
}
