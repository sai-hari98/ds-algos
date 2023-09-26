package matrix;

/**
 * Link: https://leetcode.com/problems/set-matrix-zeroes
 */
public class SetMatrixZeroes {

    private int[][] matrix;

    public SetMatrixZeroes(int[][] matrix) {
        this.matrix = matrix;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        SetMatrixZeroes matrixZeroes = new SetMatrixZeroes(matrix);
        matrixZeroes.setZeroesNotOptimized();
        matrixZeroes.setZeroes();
    }

    /**
     * This method uses O(1) space complexity and O(mn) time complexity.
     * The idea is to mark the first element of ith row and jth col to be zero if the element in ith row and jth col is zero.
     * For col 0, we are having a separate attribute because:
     * matrix[i][j] & matrix[j][i] are the same (i and j are 0). So we won't exactly know if we have to mark only the row zero
     * or column zero.
     */
    public void setZeroes() {
        int firstCol = 1;
        /**
         * Check for col 0
         */
        for(int i=0;i<matrix.length;i++){
            if(matrix[i][0] == 0){
                firstCol = 0;
                break;
            }
        }
        /**
         * Check for row 0
         */
        for(int i=0;i<matrix[0].length;i++){
            if(matrix[0][i] == 0){
                matrix[0][0] = 0;
                break;
            }
        }
        /**
         * Check for other elements
         */
        for(int i = 1; i < matrix.length ; i++){
            for(int j=1;j<matrix[0].length;j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        /**
         * marking 0 for other rows and cols
         */
        for(int i = 1; i < matrix.length ; i++){
            for(int j=1;j<matrix[0].length;j++){
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }
        /**
         * condition check for 0th row and marking zero
         */
        if(matrix[0][0] == 0){
            for(int j = 0; j < matrix[0].length; j++){
                matrix[0][j] = 0;
            }
        }
        /**
         * same as above for column 0
         */
        if(firstCol == 0){
            for(int i = 0; i < matrix.length; i++){
                matrix[i][0] = 0;
            }
        }
    }

    /**
     * Not an optimized solution in terms of space. It takes up O(m+n) space.
     * Time complexity is the same as above O(mn).
     */
    public void setZeroesNotOptimized() {
        /**
         * Idea is if a particular element is 0 (row i and col j)
         * rowIdxs[i] = 1 and colIdxs[j] = 1;
         * Later the matrix is reiterated and checked if rowIdxs[i] = 1 or colIdxs[j] = 1.
         * If it is, the element is set to zero
         */
        int[] rowIdxs = new int[matrix.length];
        int[] colIdxs = new int[matrix[0].length];
        for(int i = 0; i < matrix.length ; i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j] == 0){
                    rowIdxs[i] = 1;
                    colIdxs[j] = 1;
                }
            }
        }
        for(int i = 0; i < matrix.length ; i++){
            for(int j=0;j<matrix[0].length;j++){
                if(rowIdxs[i] == 1 || colIdxs[j] == 1){
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
