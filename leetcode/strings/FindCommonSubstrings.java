package strings;

import java.util.Arrays;
import java.util.List;

/**
 * Paycom round 1 problem
 * Optimized vs Non Optimized solution difference
 * 1 MS
 */
public class FindCommonSubstrings {

    private List<String> arrayA;
    private List<String> arrayB;

    public FindCommonSubstrings(List<String> arrayA, List<String> arrayB) {
        this.arrayA = arrayA;
        this.arrayB = arrayB;
    }

    public void findCommonSubstringsNotOptimized(){
        long startTime = System.currentTimeMillis();
        for(int i = 0; i< arrayA.size(); i++){
            String str1 = "";
            String str2 = "";
            if(arrayA.get(i).length() > arrayB.get(i).length()){
                str1 = arrayB.get(i);
                str2 = arrayA.get(i);
            }else{
                str1 = arrayA.get(i);
                str2 = arrayB.get(i);
            }
            int fl = 0;
            for(int j = 1; j <= str1.length(); j++){
                if(str2.contains(String.valueOf(str1.substring(0,i)))){
                    fl = 1;
                    break;
                }
            }
            if(fl == 1)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
        System.out.println("Total Time in Not optimized approach: "+ (System.currentTimeMillis() - startTime));
    }

    public void findCommonSubstrings(){
        long startTime = System.currentTimeMillis();
        for(int i = 0; i< arrayA.size(); i++){
            char[] str1Chars = arrayA.get(i).toCharArray();
            String str2 = arrayB.get(i);
            int fl = 0;
            for(char str1Char : str1Chars){
                if(str2.contains(String.valueOf(str1Char))){
                    fl = 1;
                    break;
                }
            }
            if(fl == 1)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
        System.out.println("Total Time in optimized approach: "+ (System.currentTimeMillis() - startTime));
    }

    public static void main(String[] args) {
        FindCommonSubstrings findCommonSubstrings = new FindCommonSubstrings(Arrays.asList("hello","hi"),Arrays.asList("world", "bye"));
        findCommonSubstrings.findCommonSubstrings();
        findCommonSubstrings.findCommonSubstringsNotOptimized();
    }
}
