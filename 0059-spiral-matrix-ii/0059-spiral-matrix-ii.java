class Solution {
    public int[][] generateMatrix(int n) {
        int [][] matrix = new int [n][n];
        // Directions : right, down, left, up
        int [] dr = {0,1,0,-1};
        int [] dc = {1,0,-1,0};
        int dir = 0;    // Start with 'right'
        int row = 0, col = 0;
        for(int i = 1; i <= n*n; i++){
            matrix[row][col] = i;
            int nextRow = row + dr[dir];
            int nextCol = col + dc[dir];

            // Check if direction needs to change
            if(nextRow < 0 || nextRow >= n || nextCol < 0 || nextCol >= n || matrix[nextRow][nextCol] != 0){
                dir = (dir + 1) % 4;    // rotate direction
                nextRow = row + dr[dir];
                nextCol = col + dc[dir];
            }
            row = nextRow;
            col = nextCol;
        }  
        return matrix;
    }
}