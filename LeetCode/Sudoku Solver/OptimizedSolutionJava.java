class Solution {
    static int N;
    static int boxSize;
    static boolean[][] rowUsed, colUsed, boxUsed;

    public static void solveSudoku(char[][] board) {
        N = board.length;
        boxSize = (int) Math.sqrt(N);

        rowUsed = new boolean[N][N + 1];
        colUsed = new boolean[N][N + 1];
        boxUsed = new boolean[N][N + 1];

        // Initialize state
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (board[r][c] != '.') {
                    int num = board[r][c] - '0';
                    rowUsed[r][num] = true;
                    colUsed[c][num] = true;
                    boxUsed[getBoxIndex(r, c)][num] = true;
                }
            }
        }

        backtrack(board, 0, 0);
    }

    private static boolean backtrack(char[][] board, int row, int col) {
        if (row == N) return true; // solved

        // Move to next row if col finished
        if (col == N) return backtrack(board, row + 1, 0);

        if (board[row][col] != '.') {
            return backtrack(board, row, col + 1);
        }

        for (int num = 1; num <= N; num++) {
            int boxIndex = getBoxIndex(row, col);
            if (!rowUsed[row][num] && !colUsed[col][num] && !boxUsed[boxIndex][num]) {
                // Place number
                board[row][col] = (char) (num + '0');
                rowUsed[row][num] = colUsed[col][num] = boxUsed[boxIndex][num] = true;

                if (backtrack(board, row, col + 1)) return true;

                // Undo move
                board[row][col] = '.';
                rowUsed[row][num] = colUsed[col][num] = boxUsed[boxIndex][num] = false;
            }
        }

        return false; // trigger backtracking
    }

    private static int getBoxIndex(int row, int col) {
        return (row / boxSize) * boxSize + (col / boxSize);
    }
}