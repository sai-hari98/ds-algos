package arrays;

/**
 * You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.
 *
 * Return true if you can reach the last index, or false otherwise.
 * Link: https://leetcode.com/problems/jump-game/description
 */
public class JumpGame {

    public static void main(String[] args) {
        System.out.println(new JumpGame().canJump(new int[]{0}));
    }

    /* My Approach. Beats 79% */
    public boolean canJump(int[] nums) {
        int jumps = nums[0];
        int maxItr = 0;
        while(maxItr < nums.length && (jumps < nums.length)){
            if(nums[maxItr] == 0)
                break;
            int i = maxItr+1;
            for(;i<=maxItr+jumps && i<nums.length ;i++){
                if(i+nums[i] > jumps){
                    jumps = i+nums[i];
                }
            }
            maxItr = maxItr+jumps;
        }
        return jumps >= nums.length-1;
    }
}
