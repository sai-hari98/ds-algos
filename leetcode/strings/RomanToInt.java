package strings;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem Link for description: https://leetcode.com/problems/roman-to-integer/description
 */
public class RomanToInt {

    public static void main(String[] args) {
        new RomanToInt().romanToIntPreviousValApproach("MCMXCIV");
    }

    public int romanToIntPreviousValApproach(String s) {
        int num = 0, prevVal = Integer.MAX_VALUE;
        for(int i=0; i<s.length();i++){
            int val = getValue(s.charAt(i));
            if(val > prevVal){
                num = num + (val-2*prevVal);
            }else{
                num+=val;
            }
            prevVal = val;
        }
        return num;
    }

    public int romanToIntApproach1(String s) {
        int num = 0;
        for(int i=0; i<s.length();){
            int val = getValue(s.charAt(i));
            int nextVal = i>=s.length()-1 ? 0 : getValue(s.charAt(i+1));
            if(nextVal > val){
                num = num + (nextVal - val);
                i+=2;
            }else{
                num+=val;
                i++;
            }
        }
        return num;
    }

    public int getValue(char romanL){
        if(romanL == 'I')
            return 1;
        if(romanL == 'V')
            return 5;
        if(romanL == 'X')
            return 10;
        if(romanL == 'L')
            return 50;
        if(romanL == 'C')
            return 100;
        if(romanL == 'D')
            return 500;
        if(romanL == 'M')
            return 1000;
        return 0;
    }

    /* My own solution. takes 6 ms - hashmap operations are costly */
    public int romanToIntCostly(String s) {
        Map<Character,Integer> mapVals = new HashMap<>();
        mapVals.put('I',1);
        mapVals.put('V',5);
        mapVals.put('X',10);
        mapVals.put('L',50);
        mapVals.put('C',100);
        mapVals.put('D',500);
        mapVals.put('M',1000);
        int num = 0;
        for(int i=0; i<s.length();){
            int val = mapVals.get(s.charAt(i));
            int nextVal = i>=s.length()-1 ? 0 : mapVals.get(s.charAt(i+1));
            if(nextVal > val){
                num = num + (nextVal - val);
                i+=2;
            }else{
                num+=val;
                i++;
            }
        }
        return num;
    }
}
