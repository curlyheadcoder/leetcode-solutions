class Solution {
    public int missingNumber(int[] nums) {
        int x = 0;
        int n = nums.length;
        for(int i = 0; i <= n; i++){
            x ^= i;
        }
        for(int i : nums){
            x ^= i;
        }
        return x;
    }
}