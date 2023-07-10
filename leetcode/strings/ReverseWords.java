package strings;

/**
 * Link: https://leetcode.com/problems/reverse-words-in-a-string
 */

public class ReverseWords {

    public static void main(String[] args) {
        reverseWords("the sky is blue");
    }
    public static String reverseWords(String s) {
        s = s.trim();
        s = s.replaceAll(" +"," ");
        String[] words = s.split(" ");
        int length = words.length;
        String temp = "";
        for(int i=0;i<length/2;i++){
            temp = words[i];
            words[i] = words[length-i-1];
            words[length-i-1] = temp;
        }
        return String.join(" ",words);
    }
}
