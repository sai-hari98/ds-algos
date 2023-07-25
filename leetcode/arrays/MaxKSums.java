package arrays;

import java.util.*;

/**
 *
 */
public class MaxKSums {

    public static void main(String[] args) {
        maxOperationsInefficient(new int[]{1,2,3,4},5);
    }


    public int maxOperationsMap(int[] nums, int k) {
        Map<Integer, Integer> valCount = new HashMap<>();
        Arrays.stream(nums).forEach(num -> {
            if(valCount.containsKey(num)){
                int count = valCount.get(num);
                valCount.put(num,++count);
            }else{
                valCount.put(num,1);
            }
        });
        int ops = 0;
        Set<Integer> valCountKeys = new HashSet<>(valCount.keySet());
        for(int key : valCountKeys){
            int count = valCount.get(key);
            if(k == (2*key)){
                ops+=count/2;
                valCount.remove(key);
            }else if(valCount.containsKey(k-key)){
                int count2 = valCount.get(k-key);
                int minCount = Math.min(count, count2);
                ops+=minCount;
                valCount.put(key,count-minCount);
                valCount.put((k-key),count2-minCount);
            }
        }
        return ops;
    }

    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int i = 0, j = nums.length-1, ops = 0;
        while(i<j){
            int sum = nums[i]+nums[j];
            if(sum == k){
                ops++;
                i++;
                j--;
            }else if(sum>k)
                j--;
            else
                i++;
        }
        return ops;
    }

    /*
        Time limit exceeding function. O(n^2)
     */
    public static int maxOperationsInefficient(int[] nums, int k) {
        int ops = 0;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i] == 0 || nums[i] >= k)
                continue;
            for(int j=i+1;j<nums.length;j++){
                if(nums[j] == 0 || nums[j] >= k)
                    continue;
                if(nums[i]+nums[j] == k){
                    nums[i] = 0;
                    nums[j] = 0;
                    ops++;
                }
            }
        }
        return ops;
    }
}
