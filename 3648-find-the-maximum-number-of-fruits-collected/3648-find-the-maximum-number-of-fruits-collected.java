import java.util.Arrays;
class Solution {
    public int maxCollectedFruits(int[][] fruits) {
        int n = fruits.length;
        int total = diagonalSum(fruits);
        total += calculateDp(fruits);

        transposeInPlace(fruits);

        total += calculateDp(fruits);
        return total;
    }
    // Sum elements on the main diagonal 
    private int diagonalSum (int [][] mat){
        int sum = 0;
        for(int i = 0; i < mat.length; i++){
            sum += mat[i][i];
        }
        return sum;
    }
    // Compute the DP logic and returns the result for the current matrix orientation
    private int calculateDp(int [][] fruits){
        int n = fruits.length;
        int [] prev = new int [n];
        int [] curr = new int [n];
        Arrays.fill(prev, Integer.MIN_VALUE);
        prev[n-1] = fruits[0][n-1];
        for(int i = 1; i < n-1; ++i){
            Arrays.fill(curr, Integer.MIN_VALUE);
            for(int j = Math.max(n-1-i, i+1); j < n; ++j){
                int best = prev[j];
                if(j - 1 >= 0) best = Math.max(best, prev[j-1]);
                if(j + 1 < n) best = Math.max(best, prev[j+1]);
                curr[j] = best + fruits[i][j];
            }
            // Swap prev and curr for next iteration
            int [] temp = prev;
            prev = curr;
            curr = temp;
        }
        return prev[n-1];
    }
    // Transpose the matrix in place
    private void transposeInPlace(int [][] mat){
        int n = mat.length;
        for(int i = 0; i < n; ++i){
            for(int j = 0; j < i; ++j){
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }
    }
}