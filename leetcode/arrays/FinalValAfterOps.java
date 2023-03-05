package arrays;

/**
 * There is a programming language with only four operations and one variable X:
 *
 * ++X and X++ increments the value of the variable X by 1.
 * --X and X-- decrements the value of the variable X by 1.
 * Initially, the value of X is 0.
 *
 * Given an array of strings operations containing a list of operations, return the final value of X after performing all the operations.
 * Problem link: https://leetcode.com/problems/final-value-of-variable-after-performing-operations/description/
 */

public class FinalValAfterOps {

    public static void main(String[] args){
        System.out.println("Final value is: "+finalValueAfterOperations(new String[]{"--X","X++","X++"}));
    }

    public static int finalValueAfterOperations(String[] operations) {
        int x = 0;
        for(int i=0;i<operations.length;i++)
            /* 44 is the ascii val between 43 (for +) and 43 (for -)
                if 43 comes, then it'll get added by one and if 45 comes, we subtract it by one
             */
            x+=(44-operations[i].charAt(1));
        return x;
    }
}
