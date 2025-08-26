class Solution {
    public boolean isValidSudoku(char[][] board) {
                boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] boxes = new boolean[9][9]; // nine 3x3 boxes

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                char ch = board[r][c];
                if (ch == '.') continue;

                int num = ch - '1'; // index 0-8
                int boxIndex = (r / 3) * 3 + (c / 3);

                if (rows[r][num]) return false;   // duplicate in row
                if (cols[c][num]) return false;   // duplicate in column
                if (boxes[boxIndex][num]) return false; // duplicate in box

                rows[r][num] = true;
                cols[c][num] = true;
                boxes[boxIndex][num] = true;
            }
        }
        return true;
    }
}