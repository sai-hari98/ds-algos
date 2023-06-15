package strings;

/**
 * Given a string s consisting of words and spaces, return the length of the last word in the string.
 *
 * A word is a maximal
 * substring
 *  consisting of non-space characters only.
 *  Link: https://leetcode.com/problems/length-of-last-word/description
 */
public class LengthLastWord {

    public static void main(String[] args) {
        new LengthLastWord().lengthOfLastWord("Hello World");
    }

    /* 0ms beats 100% */
    public int lengthOfLastWord(String s) {
        int i = s.length()-1, length=0;
        while(i>=0 && s.charAt(i) == ' '){
            i--;
        }
        while(i>=0 && s.charAt(i) != ' '){
            length++;
            i--;
        }
        return length;
    }

    public int lengthOfLastWordApproach1(String s) {
        s = s.trim();
        String[] words = s.split(" ");
        return words[words.length-1].length();
    }
}
