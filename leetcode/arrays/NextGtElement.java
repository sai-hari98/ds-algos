package arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Link: https://leetcode.com/problems/next-greater-element-i/description/
 */
public class NextGtElement {

    public static void main(String[] args) {
        nextGreaterElement(new int[]{1,3,4,2,},new int[]{4,1,2});
    }

    /*
    Makes use of a stack and hashmap to reduce the time complexity to O(m+n)
     */
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        Map<Integer,Integer> nextGtMap = new HashMap<>();
        int[] result = new int[nums1.length];
        for(int j = 0 ; j < nums2.length ; j++){

            /*
            Keep emptying the stack until the stack top is greater or equal to nums2[j]
            This is done because the stack accumulates numbers in descending order and once the first greater element is found
            ALl the elements in the stack (till stack top is gt or eq to nums2[j]) are mapped with nums2[j] as next gt ele
             */
            while(!stack.isEmpty() && stack.peek() < nums2[j]){
                nextGtMap.put(stack.pop(), nums2[j]);
            }
            /* Keep pushing the elements into the stack
                Irrespective of if nums2[j] gt or lt than nums2[j-1]
             */
            stack.push(nums2[j]);
        }

        while(!stack.isEmpty()){
            nextGtMap.put(stack.pop(), -1);
        }

        for(int i = 0 ; i<nums1.length ; i++){
            result[i] = nextGtMap.get(nums1[i]);
        }
        return result;
    }

    /*
    Brute force method O(m.n) time complexity.
     */
    public int[] nextGreaterElementBruteForce(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        for(int i = 0; i < nums1.length ; i++){
            int maxNum = -1;
            for(int j = nums2.length - 1; j >= 0 ; j--){
                if(nums2[j] == nums1[i])
                    break;
                maxNum = nums2[j] > nums1[i] ? nums2[j] : maxNum;
            }
            result[i] = maxNum;
        }
        return result;
    }
}
