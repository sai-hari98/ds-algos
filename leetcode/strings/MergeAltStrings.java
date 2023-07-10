package strings;

/**
 * Link: https://leetcode.com/problems/merge-strings-alternately
 */
public class MergeAltStrings {

    public static void main(String[] args) {
        mergeAlternately("abc","pqr");
    }

    public static String mergeAlternately(String word1, String word2) {
        int i=0,j=0,res=0;
        char[] word1Arr = word1.toCharArray();
        char[] word2Arr = word2.toCharArray();
        char[] result = new char[word1.length()+word2.length()];
        while(i<word1.length()||j<word2.length()){
            if(i<word1.length()){
                result[res] = word1Arr[i];
                i++;
                res++;
            }
            if(j<word2.length()){
                result[res] = word2Arr[j];
                j++;
                res++;
            }
        }
        return new String(result);
    }

    public static String mergeAlternatelyInefficient(String word1, String word2) {
        int i=0,j=0;
        String finalStr = "";
        long initTime = System.currentTimeMillis();
        for(;i<word1.length()&&j<word2.length();i++,j++)
            finalStr = finalStr + word1.charAt(i) + word2.charAt(j);
        long time1 = System.currentTimeMillis();
        System.out.println(time1-initTime);
        finalStr = finalStr + word1.substring(i,word1.length());
        long time2 = System.currentTimeMillis();
        System.out.println(time2-time1);
        finalStr = finalStr + word2.substring(j,word2.length());
        long time3 = System.currentTimeMillis();
        System.out.println(time3-time2);
        return finalStr;
    }
}
