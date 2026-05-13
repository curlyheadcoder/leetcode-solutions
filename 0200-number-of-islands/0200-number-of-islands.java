class Solution {
    public int numIslands(char[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        int islands = 0;
        for(int r = 0; r < rows; r++){
            for(int c = 0; c < cols; c++){
                if(grid[r][c] == '1'){
                    islands++;
                    dfs(grid, r, c);        // now go for all 4 direction up, down, left, right
                }
            }
        } 

        return islands;
    }
    private void dfs(char [][] grid, int r, int c){
        int rows = grid.length, cols = grid[0].length;
        // boundary checks
        if(r < 0 || c < 0 || r >= rows || c>= cols || grid[r][c] == '0') return;

        grid[r][c] = '0';       // mark visited so we will not do dfs again 

        // lets explore 4 directions 
        dfs(grid, r+1, c);   // down
        dfs(grid, r-1, c);   // up
        dfs(grid, r, c-1);   // left
        dfs(grid, r, c+1);   // right
    }
}