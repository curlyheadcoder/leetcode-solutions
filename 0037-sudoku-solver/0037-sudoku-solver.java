class Solution {
    private static final int SIZE = 9;

    public void solveSudoku(char[][] board) {
        solve(board);
    }

    private boolean solve(char[][] board) {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if (board[row][col] == '.') { // empty cell
                    for (char num = '1'; num <= '9'; num++) {
                        if (isValid(board, row, col, num)) {
                            board[row][col] = num;

                            if (solve(board)) {
                                return true;
                            }

                            board[row][col] = '.'; // backtrack
                        }
                    }
                    return false; // no valid number found, backtrack
                }
            }
        }
        return true; // solved
    }

    private boolean isValid(char[][] board, int row, int col, char num) {
        int boxRowStart = (row / 3) * 3;
        int boxColStart = (col / 3) * 3;

        for (int i = 0; i < SIZE; i++) {
            // check row
            if (board[row][i] == num) return false;
            // check column
            if (board[i][col] == num) return false;
            // check 3x3 box
            int boxRow = boxRowStart + i / 3;
            int boxCol = boxColStart + i % 3;
            if (board[boxRow][boxCol] == num) return false;
        }
        return true;
    }
}
