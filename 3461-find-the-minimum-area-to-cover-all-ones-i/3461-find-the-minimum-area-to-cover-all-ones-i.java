class Solution {
    public int minimumArea(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int t = m, b = -1, l = n, r = -1;
        // Traverse grid and update bounds 
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    t = Math.min(t,i);
                    b = Math.max(b, i);
                    l = Math.min(l, j);
                    r = Math.max(r, j);
                }
            }
        }
        return (b - t + 1) * (r - l + 1);
    }
}