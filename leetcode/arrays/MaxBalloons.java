package arrays;

/**
 * Problem Link: https://leetcode.com/problems/maximum-number-of-balloons/
 */
public class MaxBalloons {

    /**
     * The below method finds the maximum number of times the word balloon can be formed with the characters of the string text
     * Each character can be used only once.
     * @param text
     * @return number of times balloon text can be formed using input text.
     */
    public int maxNumberOfBalloons(String text) {
        int[] charCount = new int[26];
        for(char c : text.toCharArray()){
            int pos = c - 97;
            charCount[pos]++;
        }
        int[] balloonCharCount = new int[]{charCount[0],charCount[1],charCount['l'-97]/2, charCount['o'-97]/2, charCount['n'-97]};
        int noOfBalloons = balloonCharCount[0];
        for(int count : balloonCharCount)
            noOfBalloons = Math.min(count, noOfBalloons);
        return noOfBalloons;
    }
}
