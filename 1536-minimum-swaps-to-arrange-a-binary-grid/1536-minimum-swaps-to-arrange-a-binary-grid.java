class Solution {
    public int minSwaps(int[][] grid) {
        int n = grid.length;
        int [] trailingZeroes = new int [n];
        int swaps = 0;
        // count trailing zeroes
        for(int i = 0; i < n; i++){
            int count = 0;
            for(int j = n-1; j >= 0; j--){
                if(grid[i][j] == 0) count++;
                else break;
            }
            trailingZeroes[i] = count;
        }
        for(int i = 0; i < n; i++){
            int required = n-1-i;
            int j = i;
            while(j < n && trailingZeroes[j] < required){
                j++;
            }
            if(j == n) return -1;
            while(j > i){
                int temp = trailingZeroes[j];
                trailingZeroes[j] = trailingZeroes[j-1];
                trailingZeroes[j-1] = temp;
                j--;
                swaps++;
            }
        }
        return swaps;
    }
}