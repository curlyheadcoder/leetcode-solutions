class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int maxDiagonal = 0, maxArea = 0;
        for(int [] rect : dimensions){
            int l = rect[0], w = rect[1];
            int diagonal = l * l + w * w;
            int area = l * w;

            if(diagonal > maxDiagonal){
                maxDiagonal = diagonal;
                maxArea = area;
            }else if(diagonal == maxDiagonal && area > maxArea){
                maxArea = area;
            }
        }
        return maxArea;
    }
}