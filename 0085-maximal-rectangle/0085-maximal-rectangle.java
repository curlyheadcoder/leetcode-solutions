class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length == 0) return 0;
        int n = matrix.length;
        int m = matrix[0].length;
        int [] heights = new int [m];
        int maxArea = 0;
        for(int i = 0; i < n; i++){
            // update Histogram for each row
            for(int j = 0; j < m; j++){
                if(matrix[i][j] == '1'){
                    heights[j]++;
                }
                else{
                    heights[j] = 0;
                }
            }
            //Calculate max area for current row's histogram
            maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }
        return maxArea;
    }
    // Helper function to calculate max area in histogram
    private int largestRectangleArea(int [] heights){
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int n = heights.length;
        int i = 0;
        while(i < n){
            if(stack.isEmpty() || heights[i] >= heights[stack.peek()]){
                stack.push(i++);
            }else{
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek()- 1;
                maxArea = Math.max(maxArea, height * width);
            }
        }
        while(!stack.isEmpty()){
            int height = heights[stack.pop()];
            int width = stack.isEmpty() ? i : i - stack.peek() - 1;
            maxArea = Math.max(maxArea, height * width);
        }
        return maxArea;

    }
}