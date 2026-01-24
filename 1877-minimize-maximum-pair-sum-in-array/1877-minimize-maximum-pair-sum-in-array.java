class Solution {
    public int minPairSum(int[] nums) {
        int i = 0, j = nums.length-1;
        int res = Integer.MIN_VALUE;
        Arrays.sort(nums);
        while(i < j){
            int sum = nums[i] + nums[j];
            res = Math.max(res, sum);
            i++;
            j--;
        }
        return res;
    }
}