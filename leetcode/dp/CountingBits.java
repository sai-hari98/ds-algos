package dp;

/**
 * Problem Description: https://leetcode.com/problems/counting-bits/
 */
public class CountingBits {

    /**
     * The method computes the number of 1's for each number between 0 and the number n (inclusive)
     * Using dynamic programming, this becomes a lot more easier rather than to convert each number to its binary form

     * There are only 3 possibilities to consider:
     * 1. If the number is a power of 2. (4, 8, 16, 32, ...).
     * In this case, number of 1's will be just 1

     * 2. Else if the number is divisible by 2 (6, 12, 14, 18, ...). In this case number of 1's will be
     * Previous number's 1's count - (power of 2 in 2^k - 1)

     * 3. If number is not divisible by 2. Then number of 1's will be
     * Previous number's 1's count + 1

     * @param n - number to consider to count bits from 0 to n;
     * @return array of integers in which ith index contains the count of 1's in the binary representation of i
     */
    public static int[] countBits(int n) {
        int[] ones = new int[n+1];
        ones[0] = 0;
        for(int i = 1 ; i <= n ; i++){
            if(i%2 != 0)
                ones[i] = ones[i-1]+1;
            else {
                int num = i;
                int pow = 0;
                while(num % 2 == 0){
                    pow++;
                    num/=2;
                }
                if(num == 1){
                    ones[i] = 1;
                } else {
                    ones[i] = ones[i-1] - (pow - 1);
                }
            }
        }
        return ones;
    }

    public static void main(String[] args){
        countBits(5);
    }
}
