class Solution {
    public int countPartitions(int[] nums) {
        int sumLeft = 0, sumRight = sum(nums), count = 0;
        for(int i = 0; i < nums.length - 1; i++){
            sumLeft += nums[i];
            sumRight -= nums[i];
            if((sumRight - sumLeft) % 2 == 0) count++;
        }
        return count;
    }
    private int sum(int [] nums){
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        return sum;
    }
}