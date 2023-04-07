package strings;

public class ReverseVowels {

    public static void main(String[] args){

    }



    /* My Own approach */
    public static String reverseVowels(String s) {
        int i = 0,j=s.length()-1;
        char[] charArr = s.toCharArray();
        Character lChar = null,rChar = null;
        while(i<j){
            if(lChar != null && rChar != null){
                charArr[i] = rChar;
                charArr[j] = lChar;
                rChar = null;
                lChar = null;
                i++;
                j--;
            }

            if(checkIfCharIsVowel(charArr[i])){
                lChar = charArr[i];
            }else{
                i++;
            }

            if(checkIfCharIsVowel(charArr[j])){
                rChar = charArr[j];
            }else{
                j--;
            }

        }
        return new String(charArr);
    }

    public static String reverseVowelsApproach2(String s) {
        int i = 0,j=s.length()-1;
        char[] charArr = s.toCharArray();
        while(i<j){

            /* The i<j condition enforces the increments to be bound within the string length */
            /* we keep incrementing and if the input string does not have a vowel the loop will end in error at a point
            with indexoutofbounds exception
             */
            while(i<j && !checkIfCharIsVowel(charArr[i])){
                i++;
            }

            while(i<j && !checkIfCharIsVowel(charArr[j])){
                j--;
            }

            char temp = charArr[i];
            charArr[i] = charArr[j];
            charArr[j] = temp;
            i++;
            j--;

        }
        return new String(charArr);
    }

    private static boolean checkIfCharIsVowel(char c){
        Character lCaseC = Character.toLowerCase(c);
        if(lCaseC == 'a' || lCaseC == 'e' || lCaseC == 'i' || lCaseC == 'o' || lCaseC == 'u'){
            return true;
        }
        return false;
    }
}
