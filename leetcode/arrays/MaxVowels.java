package arrays;

/**
 * Link: https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length
 */
public class MaxVowels {

    public static void main(String[] args) {
        maxVowels("abciiidef", 3);
    }

    /*
    Beats 97.82% of users in runtime.
    Same sliding window approach.
    Avoids multiple calls for same vowel contrary to the previous approach
     */
    public static int maxVowels(String s, int k) {
        int vowels = 0, i = 0;
        char[] chars = s.toCharArray();
        for(;i<k;i++){
            int vowel = isVowel(chars[i]);
            vowels+=vowel;
            if(i+k < chars.length)
                chars[i] = (char) (chars[i+k] - vowel);
        }
        int maxVowels = vowels;
        for(;i<chars.length;i++){
            int vowel = isVowel(chars[i]);
            vowels += vowel - (int) (chars[i]-chars[i-k]);
            if(vowels>maxVowels){
                maxVowels = vowels;
            }
            if(i+k < chars.length)
                chars[i] = (char) (chars[i+k] - vowel);
        }
        return maxVowels;
    }

    public static int isVowel(char c){
        if(c == 'a' || c == 'e' || c == 'o' || c == 'i' || c == 'u')
            return 1;
        return 0;
    }

    /*
    Beats 96.65% of users
    Sliding Window but multiple function calls for the same character.
     */
    public static int maxVowelsApproach1(String s, int k) {
        int vowels = 0, i = 0;
        char[] chars = s.toCharArray();
        for(;i<k;i++)
            vowels+=isVowel(chars[i]);
        int maxVowels = vowels;
        for(;i<chars.length;i++){
            vowels += isVowel(chars[i])-isVowel(chars[i-k]);
            if(vowels>maxVowels){
                maxVowels = vowels;
            }
        }
        return maxVowels;
    }
}
