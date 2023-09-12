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
        System.out.println(validSudoku.isValidSudokuHashMap());
    }

    public boolean isValidSudokuHashMap() {
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
                if(rowEntries[i].containsKey(board[i][j]))
                    return false;
                if(colEntries[j].containsKey(board[i][j]))
                    return false;
                int gridIndex = (i/3)*3+(j/3);
                if(boxEntries[gridIndex].containsKey(board[i][j]))
                    return false;

                if(board[i][j] != "."){
                    rowEntries[i].put(board[i][j],1);
                    colEntries[j].put(board[i][j],1);
                    boxEntries[gridIndex].put(board[i][j],1);
                }
            }
        }
        return true;
    }


}
