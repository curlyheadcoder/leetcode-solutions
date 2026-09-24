class Solution {
    public int smallestIndex(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            int num = nums[i];
            int digSum = 0;
            while(num > 0){
                digSum += num % 10;
                num /= 10;
            }
            if(digSum == i){
            return i;
            }
        }
        return -1;
    }
}