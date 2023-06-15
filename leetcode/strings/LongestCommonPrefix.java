package strings;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 * If there is no common prefix, return an empty string "".
 * Link: https://leetcode.com/problems/longest-common-prefix/description
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {
        new LongestCommonPrefix().longestCommonPrefix(new String[]{"flower","flow","flight"});
    }

    public String longestCommonPrefix(String[] strs) {
        String subStr = strs[0];
        for(int i=1;i<strs.length;i++){
            int idx = Math.min(subStr.length(), strs[i].length()), j=0;
            for(;j<idx;j++){
                if(subStr.charAt(j) != strs[i].charAt(j))
                    break;
            }
            subStr = strs[i].substring(0,j);
            if(subStr.length() == 0)
                break;
        }
        return subStr;
    }
}
