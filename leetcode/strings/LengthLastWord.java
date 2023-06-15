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
    public int lengthOfLastWord(String s) {
        s = s.trim();
        String[] words = s.split(" ");
        return words[words.length-1].length();
    }
}
