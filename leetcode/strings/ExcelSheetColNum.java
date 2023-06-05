package strings;

/**
 * Given a string columnTitle that represents the column title as appears in an Excel sheet, return its corresponding column number.
 * Problem link: https://leetcode.com/problems/excel-sheet-column-number/description/
 */
public class ExcelSheetColNum {

    public static void main(String[] args){
        System.out.println(new ExcelSheetColNum().titleToNumber("ZY"));
    }
    public int titleToNumber(String columnTitle) {
        int val = 0;
        int multiplier = 1;
        for(int i=columnTitle.length()-1;i>=0;i--){
            val = val+(multiplier*(columnTitle.charAt(i)-'A'+1));
            multiplier*=26;
        }
        return val;
    }
}
