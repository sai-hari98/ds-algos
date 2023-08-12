package arrays;

/**
 * Link: https://leetcode.com/problems/rotate-array
 */
public class RotateArray {

    public static void main(String[] args) {
        rotateCopyArr(new int[]{1,2,3,4,5,6,7}, 3);
    }


    /*
        Simple implementation to have another secondary array to store the rotated results.
        Rotation performed by adding the index to K (no of steps for rotation).

        Copy the results from the secondary array to nums. Takes space complexity O(n) which is overhead.
     */
    public static void rotateCopyArr(int[] nums, int k) {
        if(k == 0)
            return;
        int len = nums.length;
        int[] copyArr = new int[len];
        for(int i = 0; i<len ; i++){
            int copyArrIdx = (i+k)%len;
            copyArr[copyArrIdx] = nums[i];
        }
        for(int i = 0; i<len; i++)
            nums[i] = copyArr[i];
    }
}
