package matrix;

import java.util.HashMap;
import java.util.Map;

public class ValidSudoku {

    private String[][] board;

    public ValidSudoku(String[][] board) {
        this.board = board;
    }

    public static void main(String[] args) {
        String[][] board = new String[][]{{"5","3",".",".","7",".",".",".","."}
,{"6",".",".","1","9","5",".",".","."}
,{".","9","8",".",".",".",".","6","."}
,{"8",".",".",".","6",".",".",".","3"}
,{"4",".",".","8",".","3",".",".","1"}
,{"7",".",".",".","2",".",".",".","6"}
,{".","6",".",".",".",".","2","8","."}
,{".",".",".","4","1","9",".",".","5"}
,{".",".",".",".","8",".",".","7","9"}};
        ValidSudoku validSudoku = new ValidSudoku(board);
        System.out.println(validSudoku.isValidSudokuBitMasking());
    }

    /**
     * Sudoku validation has 3 basic rules.
     * 1. Each row should have one number only once
     * 2. Each column should have one number only once
     * 3. Each grid (9 tiles) should have one number only once. There are 9 grids in a sudoku board.
     */

    public boolean isValidSudokuHashMap() {
        /**
         * The idea is to create a hashmap for each row, column and grid.
         * If any of them already contain the value, return false.
         * In the end, if all conditions satisfy return true.
         */
        Map<String,Integer>[] rowEntries = new HashMap[board.length];
        Map<String,Integer>[] colEntries = new HashMap[board.length];
        Map<String,Integer>[] boxEntries = new HashMap[board.length];
        for(int k = 0 ; k < 9 ; k++){
            rowEntries[k] = new HashMap<>();
            colEntries[k] = new HashMap<>();
            boxEntries[k] = new HashMap<>();
        }
        for(int i = 0 ; i< 9; i++){
            for(int j = 0 ; j < 9 ; j++){
                if(board[i][j] == ".")
                    continue;
                if(rowEntries[i].containsKey(board[i][j]))
                    return false;
                if(colEntries[j].containsKey(board[i][j]))
                    return false;
                /**
                 * How to identify the grid position for each tile? (0 - 8)
                 * We can use the following math operation (r/3)*3 + (c/3)
                 * For eg: for grid 5 (labelled 4), eg: r = 3 and c = 3
                 * grid will be (3/3)*3 + (3/3) = 4
                 */
                int gridIndex = (i/3)*3+(j/3);
                if(boxEntries[gridIndex].containsKey(board[i][j]))
                    return false;
                rowEntries[i].put(board[i][j],1);
                colEntries[j].put(board[i][j],1);
                boxEntries[gridIndex].put(board[i][j],1);
            }
        }
        return true;
    }

    public boolean isValidSudokuArrayMapping() {
        /**
         * Change of the data structure used to keep track of the numbers.
         * Instead of a hashmap, we can use three 2D arrays - one for each row, column and grid.
         * outer dimension is the row, col or grid and inner dimension is for the 9 numbers from 0 to 8.
         * Return false if the value in [i][value-1] is 1. else change its value to 1 (first occurance).
         * Return true if all the conditions satisfy
         */
        int[][] rows = new int[9][9];
        int[][] cols = new int[9][9];
        int[][] grid = new int[9][9];
        for(int i = 0 ; i< 9 ; i++){
            for(int j=0;j<9;j++){
                if(board[i][j].equals("."))
                    continue;
                int num = Integer.parseInt(board[i][j]) - 1;
                int gridIdx = (i/3)*3 + j/3;
                if((rows[i][num] != 0)
                    && (cols[j][num] != 0)
                    && (grid[gridIdx][num] != 0)){
                    return false;
                }
                rows[i][num] = 1;
                cols[j][num] = 1;
                grid[gridIdx][num] = 1;
            }
        }
        return true;
    }

    public boolean isValidSudokuBitMasking() {
        /**
         * Optimization on space over the previous solution
         * Instead of a hashmap, we can use three arrays - one for each row, column and grid.
         * Return true if all the conditions satisfy
         */
        int[] rows = new int[9];
        int[] cols = new int[9];
        int[] grid = new int[9];
        for(int i = 0 ; i< 9 ; i++){
            for(int j=0;j<9;j++){
                if(board[i][j].equals("."))
                    continue;
                int num = Integer.parseInt(board[i][j]);
                /**
                 * Bit shifting to the left by num-1 times
                 * it is done to keep the ith bit (0-8 bits representing the numbers from 1 to 9) 1.
                 */
                int pos = 1<<(num-1);
                int gridIdx = (i/3)*3 + j/3;
                /**
                 * Bitwise AND operation checks if the ith bit is already set to 1.
                 * This is checked for the corresponding row, column and grid.
                 * If any of them is gt than 0, it means the row already has that number and hence should return false.
                 */
                if(((rows[i] & pos) > 0)
                        || ((cols[j] & pos) > 0)
                        || ((grid[gridIdx] & pos) > 0)){
                    return false;
                }
                /**
                 * Bitwise OR operation is used to set the ith bit of the particular row, column and grid to 1.
                 * The 1 indicates that number (i+1) is present in that row.
                 */
                rows[i] |= pos;
                cols[j] |= pos;
                grid[gridIdx] |= pos;
            }
        }
        return true;
    }


}
