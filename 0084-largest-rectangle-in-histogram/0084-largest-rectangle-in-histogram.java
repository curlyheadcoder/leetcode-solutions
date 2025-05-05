class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int maxArea = 0;
        int n = heights.length;
        for(int i = 0; i <= n; i++){
            int currHeight = (i == n) ? 0 : heights[i];
            while(!st.isEmpty() && currHeight < heights[st.peek()]){
                int h = heights[st.pop()];
                int w = st.isEmpty() ? i : i - st.peek() - 1;
                maxArea = Math.max(maxArea, h*w);
            }
            st.push(i);
        }
        return maxArea;
    }
}