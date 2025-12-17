class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int left = 0, right = n-1;
        int maxArea = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            int area = Math.min(height[left], height[right]) * (right - left);
            maxArea = Math.max(area, maxArea);
            if(height[left]< height[right]){
                left++;
            }else{
                right--;
            }
        }
        return maxArea;
    }
}