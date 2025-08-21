class Solution {
    public int countSquares(int[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        int res = 0, prev = 0;
        int [] dp = new int [cols + 1];
        for(int i = 1; i <= rows; i++){
            for(int j = 1; j <= cols; j++){
                if(matrix[i-1][j-1] == 1){
                    int temp = dp[j];
                    dp[j] = 1 + Math.min(prev, Math.min(dp[j-1], dp[j]));
                    prev = temp;
                    res += dp[j];
                }else{
                    dp[j] = 0;
                }
            }
        }
        return res;
    }
}