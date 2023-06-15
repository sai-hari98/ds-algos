package arrays;

/**
 * You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.
 *
 * Merge nums1 and nums2 into a single array sorted in non-decreasing order.
 *
 * The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.
 * Link: https://leetcode.com/problems/merge-sorted-array
 */
public class MergeArrays {

    public static void main(String[] args) {
        new MergeArrays().merge(new int[]{1,2,3,0,0,0}, 3, new int[]{2,5,6}, 3);
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i=m-1,j=n-1, f=m+n-1;
        while(i>=0&&j>=0){
            nums1[f--] = nums1[i] > nums2[j] ? nums1[i--] : nums2[j--];
        }
        while(j>=0){
            nums1[f--] = nums2[j--];
        }
    }

    public void mergeFailed(int[] nums1, int m, int[] nums2, int n) {
        int i=0,j=0;
        for(;i<m;i++){
            if(nums1[i] > nums2[j]){
                int temp = nums1[i];
                nums1[i] = nums2[j];
                nums2[j] = temp;
                j++;
            }
        }
        j=0;
        for(;i<m+n;i++,j++){
            nums1[i] = nums2[j];
        }
    }
}
