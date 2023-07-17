package arrays;

/**
 * Link: https://leetcode.com/problems/container-with-most-water/description
 */
public class WaterContainer {

    public static void main(String[] args) {
        maxArea(new int[]{1,8,6,2,5,4,8,3,7});
    }

    public static int maxArea(int[] height) {
        int maxArea = Integer.MIN_VALUE;
        int i=0, j = height.length-1;
        while(i<j){
            int area = Math.min(height[i],height[j])*(j-i);
            if(area > maxArea)
                maxArea = area;
            if(height[i]<height[j])
                i++;
            else
                j--;

        }
        return maxArea;
    }

    /* Incomplete soln */
    public int maxAreaIncomplete(int[] height) {
        int maxArea = Integer.MIN_VALUE;
        int j = height.length-1;
        int i = j-1, maxIdx = j;
        for(;i>=0;i--,j--){
            if(height[j]*(j-i) > height[maxIdx]*(maxIdx-i)){
                maxIdx = j;
            }
            int area = Math.min(height[i],height[maxIdx])*(maxIdx-i);
            if(area > maxArea)
                maxArea = area;

        }
        return maxArea;
    }

    /* Brute force solution */
    public static int maxAreaBruteForce(int[] height) {
        int maxArea = Integer.MIN_VALUE;
        for(int i=0;i<height.length-1;i++){
            for(int j=i+1;j<height.length;j++){
                int area = Math.min(height[i],height[j])*(j-i);
                if(area>maxArea)
                    maxArea = area;
            }
        }
        return maxArea;
    }
}
