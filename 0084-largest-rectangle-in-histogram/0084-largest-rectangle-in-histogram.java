class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int size = heights.length;
        int maxArea = 0;
        int index = 0;

        while(index < size){
            if(st.isEmpty() || heights[st.peek()] <= heights[index]){
                st.push(index);
                index++;
            }else{
                int poppedIndex = st.pop();
                int height = heights[poppedIndex];
                int width = st.isEmpty() ? index : index - st.peek() - 1;
                int area = height * width;
                if(area > maxArea){
                    maxArea = area;
                } 
            }
        }
        while(!st.isEmpty()){
            int poppedIndex = st.pop();
            int height = heights[poppedIndex];
            int width = st.isEmpty() ? index : index - st.peek() - 1;
            int area = height * width;
            if(area > maxArea){
                maxArea = area;
            }
        }
        return maxArea;
    }
}