package arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * The problem is about finding if there are recurring elements in an integer array
 * Link: https://leetcode.com/problems/contains-duplicate/description/
 */
public class ContainsDuplicates {

    private int[] nums;

    public ContainsDuplicates(int[] nums) {
        this.nums = nums;
    }

    /**
     * This method uses a hash table to check if the same element is present during insertion.
     * This method performs better than the next one for large inputs. The time complexity will be around O(n).
     * Space complexity of O(n).
     *
     * Downside: For smaller inputs, the below algo O(n log n) might have better shorter runtime than this O(n).
     *
     * @param nums
     * @return
     */
    public boolean containsDuplicateHashTable(int[] nums) {
        // set to store numbers
        Set<Integer> numStack = new HashSet<>();
        for(int num : nums){
            // check if number is getting inserted. if no, that means the number is already present.
            if(!numStack.add(num))
                return true;
        }
        return false;
    }

    /**
     * Uses sorting to identify duplicates
     * Time complexity will be O(n log n) and space complexity optimistically should be O(1) but Arrays.sort uses some space.
     * Hence, its space complexity will be around O(n).
     * @param nums
     * @return
     */
    public boolean containsDuplicate(int[] nums) {
        // time complexity of O(n log n) and space complexity of O(n) at worst case
        //sort the array to arrange the elements sequentially
        Arrays.sort(nums);
        for(int i = 1; i < nums.length ; i++){
            // if 2 consecutive elements are the same, it means they are duplicates.
            if(nums[i] == nums[i-1])
                return true;
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
