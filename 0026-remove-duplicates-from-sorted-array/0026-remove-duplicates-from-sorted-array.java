class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0) return 0;
        int ans = 0;
        for(int j = 1; j < nums.length; j++){
            if(nums[ans] != nums[j]) ans++;
            nums[ans] = nums[j];
        }
        return ans+1;
    }
}