package arrays;

/**
 * We are given a list nums of integers representing a list compressed with run-length encoding.
 *
 * Consider each adjacent pair of elements [freq, val] = [nums[2*i], nums[2*i+1]] (with i >= 0).  For each such pair, there are freq elements with value val concatenated in a sublist. Concatenate all the sublists from left to right to generate the decompressed list.
 *
 * Return the decompressed list.
 *
 * Problem Link: https://leetcode.com/problems/decompress-run-length-encoded-list/description/
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DecompressArray {

    public static void main(String[] args){
        long startTime = System.currentTimeMillis();
        int[] output = decompressRLElistOptimized(new int[]{1,2,3,4});
        long startTime1 = System.currentTimeMillis();
        int[] output1 = decompressRLElist(new int[]{1,2,3,4});
        long endTime = System.currentTimeMillis();
        //takes 0 ms
        System.out.println("Output: "+Arrays.toString(output)+ " Time: "+(startTime1-startTime));
        //takes about 4 ms
        System.out.println("Output1: "+Arrays.toString(output1)+ " Time: "+(endTime-startTime1));
    }

    public static int[] decompressRLElistOptimized(int[] nums) {
        int size = 0;
        for(int i=0;i<nums.length;i+=2)
            size+=nums[i];
        int[] result = new int[size];
        int startIdx = 0;
        for(int i=0;i<nums.length;i+=2){
            Arrays.fill(result,startIdx,startIdx+nums[i],nums[i+1]);
            startIdx+=nums[i];
        }
        return result;
    }

    public static int[] decompressRLElist(int[] nums) {
        List<Integer> decompressedList = new ArrayList<>();
        for(int i=0;i<nums.length;i+=2){
            int freq = nums[i];
            int val = nums[i+1];
            for(int j=0;j<freq;j++){
                decompressedList.add(val);
            }
        }
        return decompressedList.stream().mapToInt(i->i).toArray();
    }


}
