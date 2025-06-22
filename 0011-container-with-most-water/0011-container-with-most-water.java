class Solution {
    public int maxArea(int[] height) {
        int i = 0, j = height.length-1;
        int maxArea = Integer.MIN_VALUE;
        while(i < j){
            int h = Math.min(height[i], height[j]);
            int w = j - i;
            maxArea = Math.max(maxArea, h * w);
            if(height[i] < height[j]) i++;
            else j--;
        }
        return maxArea;
    }
}