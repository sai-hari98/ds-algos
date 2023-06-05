package strings;

import java.util.Arrays;

/**
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 *
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
 * Problem link: https://leetcode.com/problems/valid-anagram/
 */
public class AnagramCheck {

    public static void main(String[] args){
        System.out.println(new AnagramCheck().isAnagram("anagram","nagaram"));

    }

    public boolean isAnagram(String s, String t){
        if(t.length() != s.length())
            return false;
        int[] lcaseArr = new int[26];
        for(int i=0;i<t.length();i++){
            lcaseArr[s.charAt(i)-'a']++;
            lcaseArr[t.charAt(i)-'a']--;
        }
        /* using the conventional loop reduces the time by 2 ms */
        for(int i=0;i<26;i++){
            if(lcaseArr[i] != 0)
                return false;
        }
        return true;
        /*return !Arrays.stream(lcaseArr).anyMatch(val -> val != 0);*/
    }

    /* Failed approach 2
    public boolean isAnagram(String s, String t) {
        if(t.length() != s.length())
            return false;
        int strSAscii = 0, strTAscii = 0;
        for(int i=0;i<t.length();i++){
            strSAscii+=s.charAt(i);
            strTAscii+=t.charAt(i);
        }
        return strSAscii == strTAscii;
    }
     */
    /* Failed approach 1
    public boolean isAnagram(String s, String t) {
        if(t.length() != s.length())
            return false;
        int xor = 0;
        for(int i=0;i<t.length();i++){
            xor = xor ^ t.charAt(i) ^ s.charAt(i);
            System.out.println(xor);
        }
        return xor == 0;
    }*/
}
