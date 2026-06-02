class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length-1;
        int maxWater = Integer.MIN_VALUE;
        while(left < right){
            int h = Math.min(height[left], height[right]);
            int w = right - left;
            maxWater = Math.max(maxWater, h * w);
            if(height[left] < height[right]){
                left++;
            }else{
                right--;
            }
        }
        return maxWater;
    }
}