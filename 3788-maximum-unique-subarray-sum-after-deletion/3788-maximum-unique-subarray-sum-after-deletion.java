class Solution {
    public int maxSum(int[] nums) {
        int max = nums[0];
        int sum = 0;
        boolean [] used = new boolean [100001]; // Assuming -100000 <= nums[i]
        boolean hasPositive = false;
        for(int num : nums){
            if(num > 0 && !used[num]){
                sum += num;
                used[num] = true;
                hasPositive = true;
            }
            if(num > max) max = num;
        }
        return hasPositive ? sum : max;
    }
}