package arrays;

/**
 * Link: https://leetcode.com/problems/can-place-flowers
 */
public class PlaceFlowers {

    public static void main(String[] args) {
        canPlaceFlowers(new int[]{1,0,0,0,0,1}, 2);
    }

    /* Used greedy approach here */
    /* The idea is to try to place flower at an index based on the values of the adjacent indexes.
    For extreme index values, 0 , consider previous value as 0. same for n-1
     */
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        for(int i = 0; i<flowerbed.length; i++){
            if(flowerbed[i] == 0){
                int prev = i == 0 ? 0 : flowerbed[i-1];
                int next = i == flowerbed.length-1 ? 0 : flowerbed[i+1];
                if(prev == 0 && next == 0){
                    flowerbed[i] = 1;
                    count++;
                }
            }
        }
        return count >= n;
    }
}
