package arrays;

/**
 * Link: https://leetcode.com/problems/rotate-array
 */
public class RotateArray {

    public static void main(String[] args) {
        rotateCopyArr(new int[]{1,2,3,4,5,6,7}, 3);
        rotateReverseMethod(new int[]{1,2,3,4,5,6,7}, 3);
    }

    /*
        Implementation does reversal by using k to find pivot point in the array
        which can be used to reverse back the already reversed array
        eg: 1,2,3,4,5,6,7 and k=3
        Step 1: Reverse complete array -> 7,6,5,4,3,2,1
        Step 2: Reverse first k elements (0 to 2) -> 5,6,7,4,3,2,1
        Step 2: Reverse rest elements to the right -> 5,6,7,1,2,3,4
     */
    public static void rotateReverseMethod(int[] arr, int k) {
        /* Find pivot point at which we have to reverse the sub arrays */
        k%=arr.length;
        int n = arr.length;
        /* reverse the entire array */
        reverse(arr,0,n-1);
        /* reverse again 1st k elements */
        reverse(arr,0,k-1);
        /* reverse k+1 to n elements */
        reverse(arr,k,n-1);
    }

    public static void reverse(int[] arr, int start, int end){
        while(start<end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
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
