class Solution {
    public int[] getConcatenation(int[] nums) {
        int [] ans = new int [nums.length*2];
        for(int i = 0; i < nums.length; i++){
            ans[i] = nums[i];
        }
        int idx = nums.length;
        for(int i = 0; i < nums.length; i++){
            ans[idx] = nums[i];
            idx++;
        }
        return ans;
    }
}