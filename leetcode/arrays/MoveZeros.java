package arrays;

/**
 * Link: https://leetcode.com/problems/move-zeroes
 */
public class MoveZeros {

    public static void main(String[] args) {
        moveZeroes(new int[]{0,1,0,3,12});
    }

    public static void moveZeroes(int[] nums) {
        int i=0,j=0;
        for(;j<nums.length;j++){
            if(nums[i] != 0)
                i++;
            else if(nums[j] != 0){
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                i++;
            }
        }
    }
}
