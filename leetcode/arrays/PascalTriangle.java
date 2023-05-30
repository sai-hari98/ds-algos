package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalTriangle {

    public static void main(String[] args){
        System.out.println(generate(5).toString());
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascalTriangle = new ArrayList<>();
        for(int i=0;i<numRows; i++){
            Integer[] row = new Integer[i+1];
            row[0] = 1;
            row[i] = 1;
            if((i-1)>0){
                List<Integer> previousRow = pascalTriangle.get(i-1);
                for(int j=0;j<previousRow.size()-1;j++){
                    row[j+1] = previousRow.get(j)+previousRow.get(j+1);
                }
            }
            pascalTriangle.add(i, Arrays.asList(row));
        }
        return pascalTriangle;
    }
}
