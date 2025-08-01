class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int totalSum = (n *(n+1)) / 2;
        for(int num : nums){
            totalSum -= num;
        }
        return totalSum;
    }
}