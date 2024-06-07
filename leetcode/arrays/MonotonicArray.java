package arrays;

import java.util.function.BiPredicate;

public class MonotonicArray {

    /**
     * Optimized solution. Considers the array to be monotonically descending if the array first element > last element.
     * Based on it, conditions are checked iteratively throughout the array.
     * @param nums
     * @return
     */
    public static boolean isMonotonic(int[] nums) {
        int i = 0;
        boolean isNeg = (nums[nums.length - 1] < nums[0]);
        while(i < nums.length - 1){
            if(isNeg && nums[i+1] > nums[i])
                return false;
            if(!isNeg && nums[i+1] < nums[i])
                return false;
            i++;
        }
        return true;
    }

    /**
     * A convoluted solution tried out by me. Not the best runtime
     * @param nums
     * @return
     */
    public static boolean isMonotonicInefficient(int[] nums) {
        int i = 0;
        while(i < nums.length - 1 && nums[i+1] == nums[i])
            i++;
        BiPredicate<Integer,Integer> predicateToTest;
        if(i >= nums.length - 1){
            return true;
        }
        if(nums[i+1] > nums[i])
            predicateToTest = (a, b) -> b >= a;
        else
            predicateToTest = (a, b) -> b <= a;
        while(i < nums.length - 1){
            if(!predicateToTest.test(nums[i],nums[i+1])){
                return false;
            }
            i++;
        }
        return true;
    }
}
