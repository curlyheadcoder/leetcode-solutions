class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] prefix = new int[m][n];   // stores X - Y
        int[][] xCount = new int[m][n];   // stores count of X

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){

                int val = 0;
                int isX = 0;

                if(grid[i][j] == 'X'){
                    val = 1;
                    isX = 1;
                } else if(grid[i][j] == 'Y'){
                    val = -1;
                }

                prefix[i][j] = val;
                xCount[i][j] = isX;

                // build prefix for (X - Y)
                if(i > 0) prefix[i][j] += prefix[i-1][j];
                if(j > 0) prefix[i][j] += prefix[i][j-1];
                if(i > 0 && j > 0) prefix[i][j] -= prefix[i-1][j-1];

                // build prefix for X count
                if(i > 0) xCount[i][j] += xCount[i-1][j];
                if(j > 0) xCount[i][j] += xCount[i][j-1];
                if(i > 0 && j > 0) xCount[i][j] -= xCount[i-1][j-1];
            }
        }

        int res = 0;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(prefix[i][j] == 0 && xCount[i][j] > 0){
                    res++;
                }
            }
        }

        return res;
    }
}