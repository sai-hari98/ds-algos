package arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 */
public class LongestSubArraySum {

    private int []a;
    private long k;
    private int n;

    public LongestSubArraySum(int[] a, long k) {
        this.a = a;
        this.k = k;
        this.n = this.a.length;
    }

    public static void main(String[] args) {
        LongestSubArraySum longestSubArraySum = new LongestSubArraySum(new int[]{1,2,3,1,1,1,1},3);
        System.out.println(longestSubArraySum.longestSubarrayWithSumKOptimal());
    }

    public int longestSubarrayWithSumKOptimal(){
        int sum = a[0];
        int left = 0 , right = 0, maxLength = -1;
        while(right < this.n){
            while(left <= right && sum > this.k){
                sum-=a[left];
                left++;
            }
            if(sum == this.k)
                maxLength = Math.max(maxLength, right-left+1);
            right++;
            if(right < n){
                sum+=a[right];
            }
        }
        return maxLength;
    }

    public int longestSubarrayWithSumK() {
        // Write your code here
        Map<Long,Integer> prefixSumMap = new HashMap<>();
        long prefixSum = 0;
        int maxLength = -1;
        for(int i = 0; i < a.length ; i++){
            prefixSum += a[i];
            if(prefixSum == k)
                maxLength = Math.max(maxLength, i+1);
            Integer remainingSumIndex = prefixSumMap.get(prefixSum-k);
            if(remainingSumIndex != null){
                maxLength = Math.max(maxLength, i-remainingSumIndex);
            }
            if(!prefixSumMap.containsKey(prefixSum))
                prefixSumMap.put(prefixSum, i);
        }
        return maxLength;
    }
}
