package hashtable;

import java.util.HashMap;

/**
 * Link: https://leetcode.com/problems/word-pattern/description
 */
public class WordPattern {

    private String pattern;
    private String s;

    public WordPattern(String pattern, String s){
        this.pattern = pattern;
        this.s = s;
    }

    public boolean wordPattern() {
        String[] strs = s.split(" ");
        if(pattern.length() != strs.length)
            return false;
        HashMap indexMap = new HashMap();
        for(Integer i = 0 ; i<pattern.length() ; i++){
            char chr = pattern.charAt(i);
            String str = strs[i];
            if(!indexMap.containsKey(chr))
                indexMap.put(chr, i);

            if(!indexMap.containsKey(str)){
                indexMap.put(str, i);
            }

            if(indexMap.get(chr) != indexMap.get(str)){
                System.out.println(indexMap.get(chr)+" "+indexMap.get(chr).getClass());
                System.out.println(indexMap.get(str)+" "+indexMap.get(str).getClass());
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String pattern = "ccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccdd";
        String s = "s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s t t";
        WordPattern wordPattern = new WordPattern(pattern,s);
        System.out.println(wordPattern.wordPattern());
    }
}
