class Solution {
    public int[] constructTransformedArray(int[] nums) {
        int n = nums.length;
        int [] res = new int [n];
        for(int i = 0; i < n; i++){
            int move = nums[i];
            int newIdx = (i+move) % n;

            // Handle negative index
            if(newIdx < 0){
                newIdx += n;
            }
            res[i] = nums[newIdx];
        }
        return res;
    }
}