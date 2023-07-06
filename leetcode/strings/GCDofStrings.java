package strings;

/**
 * For two strings s and t, we say "t divides s" if and only if s = t + ... + t (i.e., t is concatenated with itself one or more times).
 *
 * Given two strings str1 and str2, return the largest string x such that x divides both str1 and str2.
 *
 * Link: https://leetcode.com/problems/greatest-common-divisor-of-strings
 */
public class GCDofStrings {

    public static void main(String[] args) {
        String a = "ABCABC",b="ABC";
//        gcdOfStringsIneff(a,b);
        System.out.println(gcdOfString(a,b));
    }

    public static String gcdOfString(String str1, String str2){
        /* to cover the non divisible strings */
        if(!str1.concat(str2).equals(str2.concat(str1)))
            return "";
        int gcd = gcd(str1.length(),str2.length());
        return str1.substring(0,gcd);
    }

    public static int gcd(int a, int b){
        if(b == 0)
            return a;
        else return gcd(b,a%b);
    }

    public static String gcdOfStringsIneff(String str1, String str2) {
        String commonStr = "";
        String strToConsider = str1.length()<str2.length()?str1:str2;
        for(int i=strToConsider.length()-1;i>=0;i--){
            String subStr = strToConsider.substring(0,i+1);
            int str1Len = str1.replaceAll(subStr,"").length();
            int str2Len = str2.replaceAll(subStr,"").length();
            if(str1Len == 0 && str2Len == 0){
                commonStr = subStr;
                break;
            }
        }
        return commonStr;
    }
}
