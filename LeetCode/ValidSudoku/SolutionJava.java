class Solution {
    
    public boolean isValidSudoku(char[][] board) {
        
        for (int r = 0; r < 9; r++) {
            if (!isValidRow(board, r))
                return false;
        }
        
        for (int c = 0; c < 9; c++) {
            if (!isValidCol(board, c))
                return false;
        }
        
        for (int row = 0; row < 9; row += 3) {
            for (int col = 0; col < 9; col += 3) {
                if(!isValidSubGrid(board, row, col))
                    return false;
            }
        }
        
        return true;
    }
    
    public boolean isValidRow(char[][] board, int r) {
        Set<Character> numbersInRow = new HashSet<>();
        
        for (int col = 0; col < 9; col++) {
            char cell = board[r][col];
            
            if (characterIsNumber(cell)) {
                if (numbersInRow.contains(cell)) {
                    return false;
                } else {
                    numbersInRow.add(cell);
                }
            }
        }
        
        return true;
    }
    
    public boolean isValidCol(char[][] board, int c) {
        Set<Character> numbersInRow = new HashSet<>();
        
        for (int row = 0; row < 9; row++) {
            char cell = board[row][c];
            
            if (characterIsNumber(cell)) {
                if (numbersInRow.contains(cell)) {
                    return false;
                } else {
                    numbersInRow.add(cell);
                }
            }
        }
        
        return true;
    }
    
    public boolean isValidSubGrid(char[][] board, int r, int c) {
        Set<Character> numbersInGrid = new HashSet<>();
        
        for (int row = r; row < r + 3; row++) {
            for (int col = c; col < c + 3; col++) {
                char cell = board[row][col];
                
                if (characterIsNumber(cell)) {
                    if (numbersInGrid.contains(cell)) {
                        return false;
                    } else {
                        numbersInGrid.add(cell);
                    }
                }
            }
            
        }
        return true;
    }
    
    public boolean characterIsNumber(char c) {
        return Character.isDigit(c);
    }
}