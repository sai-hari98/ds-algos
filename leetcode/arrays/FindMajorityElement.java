package arrays;

import java.util.Arrays;

/**
 * Given an array nums of size n, return the majority element.
 * The majority element is the element that appears more than ⌊n / 2⌋ times.
 * You may assume that the majority element always exists in the array.
 * Problem Link: https://leetcode.com/problems/majority-element/description/
 */

public class FindMajorityElement {

    public static void main(String[] args){
        System.out.println("Majority Element is "+new FindMajorityElement().majorityElementArraySort(new int[]{3,2,3}));
        System.out.println("Majority Element is "+new FindMajorityElement().majorityElementMooresAlgo(new int[]{3,2,3}));
    }

    /**
     * Approach 1: I am sorting the array and taking the middle element so that I can get the majority element of the array
     * In this problem, the majority element (greater than n/2 times occurances) is a guarantee.
     */
    public int majorityElementArraySort(int[] nums) {
        /* Arrays.sort has o(n log n) time complexity. */
        Arrays.sort(nums);
        return nums[(nums.length)/2];
    }

    /**
     * Boyers/Moore algo works on the intuition that since there are n/2 occurances of a particular element
     * The count of that particular element can't be nullified by the other elements in the array.
     * This voting algorithm is something i learnt from leetcode and its interesting.
     */
    public int majorityElementMooresAlgo(int[] nums){
        int majority = nums[0], count = 1;
        for(int i=1;i<nums.length;i++){
            if(count==0){
                majority = nums[i];
                count++;
            }else if(majority==nums[i])
                count++;
            else count --;
        }
        return majority;
    }
}
