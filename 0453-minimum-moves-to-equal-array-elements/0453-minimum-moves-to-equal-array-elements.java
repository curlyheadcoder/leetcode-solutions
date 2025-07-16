class Solution {
    public int minMoves(int[] nums) {
        int min = Integer.MAX_VALUE;
        int ops = 0;

        // Find minimum element
        for(int num : nums){
            if(num < min){
                min = num;
            }
        } 
        // Calculate total moves
        for(int num : nums){
            ops += num - min;
        }
        return ops;
    }
}