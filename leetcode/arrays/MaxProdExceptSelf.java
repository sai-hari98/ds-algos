package arrays;

/**
 * Link:
 */
public class MaxProdExceptSelf {

    public static void main(String[] args) {

    }

    /*
    Space complexity: O(1) other than the answer array.
    Time complexity: O(n)
     */
    public int[] productExceptSelf(int[] nums) {
        int[] answer = new int[nums.length];
        int prod = 1;

        /* Assigning the prefix product to answer array
            Multiplying the current number to prefix array after assignment
         */
        for(int i = 0; i<nums.length; i++){
            answer[i] = prod;
            prod*=nums[i];
        }
        prod = 1;
        /*
        Multiplying the suffix product variable with answer array element to get the product except self
        Multiplying the current element with prod variable to carry the suffix product to next iteration
         */
        for(int i=nums.length-1; i>=0; i--){
            answer[i] *= prod;
            prod *= nums[i];
        }
        return answer;
    }

    /*
    Space complexity is O(n) to store prefix and suffix arrays.
    More runtime.
     */
    public static int[] productExceptSelfInefficient(int[] nums) {
        int[] answer = new int[nums.length];
        int[] prefix = new int[nums.length];
        int[] suffix = new int[nums.length];
        prefix[0] = 1;
        suffix[nums.length-1] = 1;
        for(int i=1; i<nums.length; i++){
            prefix[i] = prefix[i-1]*nums[i-1];
        }
        for(int i=nums.length-2; i>=0; i--){
            suffix[i] = suffix[i+1] * nums[i+1];
        }

        for(int i = 0;i<nums.length;i++)
            answer[i] = prefix[i]*suffix[i];
        return answer;
    }
}
