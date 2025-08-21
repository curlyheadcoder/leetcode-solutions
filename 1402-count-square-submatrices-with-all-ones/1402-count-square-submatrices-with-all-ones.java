class Solution {
    public int countSquares(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int total = 0;

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                // For every cell, try all possible squares ending at (i,j)
                int maxLen = Math.min(rows - i, cols - j);
                for(int len = 1; len <= maxLen; len++){
                    boolean allOnes = true;
                    // Check if all cells in the square are 1
                    for(int x = i; x < i + len; x++){
                        for(int y = j; y < j + len; y++){
                            if(matrix[x][y] == 0){
                                allOnes = false;
                                break;
                            }
                        }
                        if(!allOnes) break;
                    }
                    if(allOnes){
                        total++;
                    }else{
                        // No need to check larger squares from this cell
                        break;
                    }
                }
            }
        }
        return total;
    }
}