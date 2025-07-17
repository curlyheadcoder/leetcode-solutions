class Solution {
    public int pivotIndex(int[] nums) {
        int total = 0, ans = -1;
        for(int num : nums) total += num;
        int ls = 0;
        for(int i = 0; i < nums.length; i++){
            int rs = total - ls - nums[i];
            if(ls == rs){
                ans = i;
                return ans;
            }
            ls += nums[i];
        }
        return ans;
    }
}