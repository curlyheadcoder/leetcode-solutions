class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int [] diff = new int [n+1];  // Difference array of size n+1
        // Apply for each query to the diffrence array
        for(int [] query : queries){
            int start = query[0];
            int end = query[1];
            diff[start] += 1;
            if(end + 1 < n){
                diff[end+1] -= 1;
            }
        }
        int cumalative = 0;
        for(int i =0; i < n; i++){
            cumalative += diff[i];
            if(cumalative < nums[i]){
                return false;   // Not enough decrements to reduce nums[i] to zero
            }
        }
        return true;   // All elements can be reduced to zero
    }
}