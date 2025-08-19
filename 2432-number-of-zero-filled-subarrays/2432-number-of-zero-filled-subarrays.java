class Solution {
    public long zeroFilledSubarray(int[] nums) {
        int z = 0;
        long ans = 0L;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                z++;
            }else{
                ans += ((long) z) * (z+1)/2;
                z = 0;
            }
        }
        ans += ((long) z) * (z+1)/2;
        return ans;
    }
}