package hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * Link: https://leetcode.com/problems/two-sum/description/
 */
public class TwoSum {

    public class Main{
        public static void main(String[] args) {
            TwoSum twoSum = new TwoSum(new int[]{2,7,11,15},9);
            System.out.println(twoSum.twoSumBruteForce());
            System.out.println(twoSum.twoSumHashMap());
        }
    }

    private int[] nums;
    private int target;

    public TwoSum(int[] nums, int target){
        this.nums = nums;
        this.target = target;
    }

    /*
        A more optimized approach.
        Record the hashmap with key,value as number,index
        At each iteration, check if the map contains the complement number (target-nums[i])
        if yes, return the current index and the complement number index from the map.
     */
    public int[] twoSumHashMap() {
        Map<Integer,Integer> indexMap = new HashMap<>();
        for(int i = 0;i<nums.length;i++){
            int complement = target-nums[i];
            if(indexMap.containsKey(complement) && indexMap.get(complement) != i){
                return new int[]{i,indexMap.get(complement)};
            }
            indexMap.put(nums[i],i);
        }
        return null;
    }

    /*
        Brute force. For every number, iterate through the numbers to its right and check if the complement number exist.
        if yes, return
        if no, return null.
     */
    public int[] twoSumBruteForce() {
        int[] indices = new int[2];
        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                int sum = nums[i]+nums[j];
                if(sum==target){
                    indices[0] = i;
                    indices[1] = j;
                    return indices;
                }
            }
        }
        return indices;
    }
}
