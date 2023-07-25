package arrays;

/**
 *
 */
public class MaxAvg {

    public static void main(String[] args) {
        findMaxAverage(new int[]{1,12,-5,-6,50,3},4);
    }

    public static double findMaxAverage(int[] nums, int k) {
        double sum = 0;
        int i=0;
        for(;i<k;i++)
            sum += nums[i];
        double maxSum = sum;
        int j = i-k;
        for(;i<nums.length;i++,j++){
            sum = sum - nums[j] + nums[i];
            if(sum > maxSum)
                maxSum = sum;
        }
        return maxSum/k;
    }
}
