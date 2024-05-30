package strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/find-and-replace-pattern/description/">Problem description</a>
 */
public class FindAndReplacePattern {

    /**
     * This method returns a list of string from the original words array which match the pattern of repetition of pattern string
     * @param words - words to check for
     * @param pattern - pattern to check for
     * @return list of words matching the pattern
     */
    public static List<String> findAndReplacePattern(String[] words, String pattern) {
        //hashmap to record the position of each character in the pattern string.
        // only first occurance index is considered
        Map<Character, Integer> patternIdxMap = new HashMap<>();
        List<String> wordsMatchingPattern = new ArrayList<>();
        int n = pattern.length();
        for(String word : words){
            // similar hashmap to patternIdxMap
            Map<Character, Integer> wordIdxMap = new HashMap<>();
            boolean isPatternMatch = true;
            for(int i = 0 ; i < n ; i++){
                char wordChar = word.charAt(i);
                char patternChar = pattern.charAt(i);
                Integer wordPos = wordIdxMap.get(wordChar);
                if(wordPos == null){
                    wordPos = i;
                    wordIdxMap.put(wordChar, i);
                }
                Integer patternPos = patternIdxMap.get(patternChar);
                if(patternPos == null){
                    patternPos = i;
                    patternIdxMap.put(patternChar, i);
                }
                //pattern doesn't match if the index of char in word and pattern doesn't match.
                //basically if the 2 strings are not in the same pattern.
                if(!wordPos.equals(patternPos)){
                    isPatternMatch = false;
                    break;
                }
            }
            if(isPatternMatch)
                wordsMatchingPattern.add(word);
        }
        return wordsMatchingPattern;
    }

    public static void main(String[] args) {
        System.out.println(findAndReplacePattern(new String[]{"abc","deq","mee","aqq","dkd","ccc"},"mee"));
    }
}
