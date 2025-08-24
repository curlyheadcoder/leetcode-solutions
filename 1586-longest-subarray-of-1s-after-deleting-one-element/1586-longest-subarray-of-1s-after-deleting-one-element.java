class Solution {
    public int longestSubarray(int[] nums) {
        boolean canDel = true;
        int n = nums.length;
        int i = 0, j = 0;
        int ans = 0;
        while(j < n){
            // make window valid
            if(nums[j] == 0){
                if(canDel == true){
                    canDel = false;
                }else{
                    while(i <= j){
                        if(nums[i] == 0){
                            i++;
                            break;
                        }
                        i++;
                    }
                }
            }
            // capture
            ans = Math.max(j-i+1, ans);
            // keep exploring
            j++;
        }
        return ans-1;
    }
}