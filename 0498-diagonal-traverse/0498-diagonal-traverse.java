class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] ans = new int[m * n];
        int idx = 0;
        
        for (int d = 0; d < m + n - 1; d++) {
            int row = (d % 2 == 0) ? Math.min(d, m - 1) : Math.max(0, d - n + 1);
            int col = d - row;
            
            while (row >= 0 && row < m && col >= 0 && col < n) {
                ans[idx++] = mat[row][col];
                if (d % 2 == 0) {  // Even diagonal → go up
                    row--;
                    col++;
                } else {           // Odd diagonal → go down
                    row++;
                    col--;
                }
            }
        }
        return ans;
    }
}
