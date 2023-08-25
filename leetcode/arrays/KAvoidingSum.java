package arrays;

import java.util.HashSet;
import java.util.Set;

/** Weekly Contest 359.
 * Link: https://leetcode.com/contest/weekly-contest-359/problems/determine-the-minimum-sum-of-a-k-avoiding-array/
 * Accepted.
 * You are given two integers, n and k.
 *
 * An array of distinct positive integers is called a k-avoiding array if there does not exist any pair of distinct elements that sum to k.
 *
 * Return the minimum possible sum of a k-avoiding array of length n.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 5, k = 4
 * Output: 18
 * Explanation: Consider the k-avoiding array [1,2,4,5,6], which has a sum of 18.
 * It can be proven that there is no k-avoiding array with a sum less than 18.
 * Example 2:
 *
 * Input: n = 2, k = 6
 * Output: 3
 * Explanation: We can construct the array [1,2], which has a sum of 3.
 * It can be proven that there is no k-avoiding array with a sum less than 3.
 */
public class KAvoidingSum {

    public int minimumSum(int n, int k) {
        int sum = 0;
        int counter = 0;
        //set to keep track of the complement numbers
        //so that it cannot be added to sum in the future iterations (2 nums summing to k)
        Set<Integer> complementSet = new HashSet<>();
        //iterate from 1 till counter reaches to n (n numbers from 1 gives min sum)
        for(int i = 1 ; counter<n  ; i++){
            int complement = k-i;
            //sum the number if its not present in the complement set.
            //and add its complement to the set.
            if(!complementSet.contains(i)){
                sum+=i;
                counter++;
                complementSet.add(complement);
            }
        }
        return sum;
    }
}
