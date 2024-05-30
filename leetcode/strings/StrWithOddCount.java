package strings;

/**
 * Problem description : <a href="https://leetcode.com/problems/generate-a-string-with-characters-that-have-odd-counts/">...</a>
 */
public class StrWithOddCount {

    /**
     * The method generates a new string with odd number of occurances for each character

     * I have chosen a and b to be my characters. If n is even, this method appends 'a' at the beginning.
     * Else just returns odd number of 'b'
     * @param n - number of characters in the output string
     * @return string with n characters, each distinct character repeated odd number of times.
     */
    public static String generateTheString(int n) {
        char[] chars = new char[n];
        int count = n;
        int index = 0;
        if(n % 2 == 0){
            count = n - 1;
            chars[0] = 'a';
            index++;
        }
        for(int i = 0 ; i < count ; i++){
            chars[index++] = 'b';
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        System.out.println(generateTheString(4));
    }
}
