package strings;

/**
 * Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
 *
 * A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).
 *
 * Link: https://leetcode.com/problems/is-subsequence/description
 */
public class IsSubsequence {

    public static void main(String[] args) {
        isSubsequence("abc","ahbgdc");
    }

    public static boolean isSubsequence(String s, String t) {
        int i=0,j=0;
        while(j<t.length() && i<s.length()){
            if(s.charAt(i) == t.charAt(j))
                i++;
            j++;
        }
        return i == s.length();
    }
}
