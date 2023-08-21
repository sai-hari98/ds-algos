package math;

import java.util.ArrayList;
import java.util.List;

/**
 * Link: https://leetcode.com/problems/palindrome-number/
 */
public class PalindromeNumber {
    private int x;
    public PalindromeNumber(int x){
        this.x = x;
    }

    // this approach is by reversing second half of the number
    // and its compared with the first half of the number.
    //if equal, then palindrome or not palindrone.
    public boolean isPalindrome() {
        if(x < 0 || (x%10 == 0 && x != 0))
            return false;
        if(x<10)
            return true;
        int revNum = 0;
        while(x>revNum){
            revNum = revNum*10+x%10;
            x/=10;
        }
        //the second or condition is something like
        //if num is 121, x will be 1 and rev num will be 12.
        //we don't care about middle digit cuz it'll make it palindrome anyways.
        //so we are also checking if x == revNum/10. Here 1 == 12/10(which is 1)
        return x == revNum || x == revNum/10;
    }

    //my own approach - takes longer
    public boolean isPalindromeApproach1() {
        //covering edge cases - nums less than 0 are not palindromes
        if(x < 0)
            return false;
        //numbers between 0 and 10 are palindromes.
        if(x<10)
            return true;
        //separating the digits and storing them in a list
        List<Integer> separatedNos = new ArrayList<>();
        while(x>0){
            separatedNos.add(x%10);
            x = x/10;
        }
        //loop to check if the numbers are the same. if not its not a palindrome.
        for(int i = 0; i<separatedNos.size()/2; i++){
            if(separatedNos.get(i) != separatedNos.get(separatedNos.size()-1-i))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        PalindromeNumber palindromeNumber = new PalindromeNumber(121);
        System.out.println(palindromeNumber.isPalindromeApproach1());
        System.out.println(palindromeNumber.isPalindrome());
    }
}
