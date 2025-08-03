class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int matRows = mat.length;
        int matCols = mat[0].length;
        
        if ( (matRows * matCols) != (r * c))
            return mat;
        
        
        int[][] result = new int[r][c];
        
        for (int row = 0; row < matRows; row++) {
            for (int col = 0; col < matCols; col++) {
                int position = (matCols * row) + col;
                int result_r = position / c;
                int result_c = position % c;
                result[result_r][result_c] = mat[row][col];
            }
        }       
        return result;
    }
}