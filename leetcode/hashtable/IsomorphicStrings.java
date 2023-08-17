package hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * Link: https://leetcode.com/problems/isomorphic-strings/description
 */
public class IsomorphicStrings {

    public class Main{
        public static void main(String[] args) {
            IsomorphicStrings isomorphicStrings = new IsomorphicStrings("foo","bar");
            System.out.println(isomorphicStrings.isIsomorphicApproach1());
        }
    }

    private String s;
    private String t;

    public IsomorphicStrings(String s,String t){
        this.s = s;
        this.t = t;
    }

    /*
    Solution for this problem is simple: No 2 same keys and no 2 same values.
    Created two hashmaps to track the duplicate keys and duplicate values.
    Returns false if condition fails anywhere
     */
    public boolean isIsomorphicApproach1() {
        boolean isValid = true;
        Map<Character, Character> replacementMap = new HashMap<>();
        Map<Character, Character> originalMap = new HashMap<>();
        for(int i = 0 ; i < s.length() ; i++){
            char chr1 = s.charAt(i);
            char chr2 = t.charAt(i);
            isValid = isValid && isReplacementValid(replacementMap, chr1, chr2)
                    && isReplacementValid(originalMap, chr2, chr1);
        }
        return isValid;
    }

    public boolean isReplacementValid(Map<Character,Character> replacementMap,
                                      char chr1, char chr2){
        if(replacementMap.containsKey(chr1)){
            char replacementChr = replacementMap.get(chr1);
            if(replacementChr != chr2)
                return false;
        }else{
            replacementMap.put(chr1, chr2);
        }
        return true;
    }
}
