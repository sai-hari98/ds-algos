package strings;

/**
 * Write a function that reverses a string. The input string is given as an array of characters s.
 *
 * You must do this by modifying the input array in-place with O(1) extra memory.
 * Link: https://leetcode.com/problems/reverse-string/description/
 */
public class ReverseString {

    public static void main(String[] args){
        char[] s = new char[]{'h','e','l','l','o'};
        reverseString(s);
    }

    public static void reverseString(char[] s) {
        int len = s.length;
        char temp;
        int mirrorIdx = len-1;
        for(int i=0;i<len/2;i++,mirrorIdx--){
            temp = s[mirrorIdx];
            s[mirrorIdx] = s[i];
            s[i] = temp;
        }
    }
}
