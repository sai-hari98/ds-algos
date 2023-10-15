package strings;

/**
 * Link: https://leetcode.com/problems/reverse-words-in-a-string-iii/?envType=daily-question&envId=2023-10-01
 */
public class ReverseWordsIII {

    private String sentence;

    public ReverseWordsIII(String sentence) {
        this.sentence = sentence;
    }

    /*
        Reversing word with a 2 pointer approach.
     */
    public String reverseWords() {
        char[] wordsChr = sentence.toCharArray();
        int i = 0, j = 0;
        for(;j < wordsChr.length; j++){
            /**
             * When wordsChr[j] is space,
             * it means the the word is between indexes i and j
             */
            if(wordsChr[j] == ' '){
                reverseWord(wordsChr, i, j);
                //after reversing -> moving i to j+1. opening index of next word
                i = j+1;
                //j will be i+1 for search
                j++;
            }
        }
        //final word reverse
        reverseWord(wordsChr, i, j);
        return new String(wordsChr);
    }

    public void reverseWord(char[] word, int i, int j){
        int n = j-1;
        for(int k = i; k<n; k++, n--){
            char temp = word[n];
            word[n] = word[k];
            word[k] = temp;
        }
    }

    public static void main(String[] args) {
        ReverseWordsIII reverseWordsIII = new ReverseWordsIII("Let's take LeetCode contest");
        System.out.println(reverseWordsIII.reverseWords());
    }
}
