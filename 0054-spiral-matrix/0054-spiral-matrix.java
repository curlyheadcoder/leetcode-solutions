class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        // Base case
        if(matrix == null || matrix.length == 0) return res;
        int rows = matrix.length, cols = matrix[0].length;
        int top = 0, bottom = rows-1, left = 0, right = cols-1;
        while(top <= bottom && left <= right){
            // 1. Traverse from left to right (Top Row)
            for(int col = left; col <= right; col++){
                res.add(matrix[top][col]);
            }
            top++;      // Move top boundary down

            // 2. Traverse from top to bottom (Right Column)
            for(int row = top; row <= bottom; row++){
                res.add(matrix[row][right]);
            }
            right--;    // Move right boundary left

            // 3. Traverse from right to left (Bottom Row)
            if(top <= bottom){
                for(int col = right; col >= left; col--){
                    res.add(matrix[bottom][col]);
                }
                bottom--;   // Move bottom boundary up
            }

            // 4. Traverse from bottom to top(Left column)
            if(left <= right){
                for(int row = bottom; row >= top; row--){
                    res.add(matrix[row][left]);
                }
                left++;     // Move left boundary right
            }
        }
        return res;
    }
}