package arrays;

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
