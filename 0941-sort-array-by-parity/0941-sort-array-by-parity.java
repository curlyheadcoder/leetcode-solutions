class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int [] output = new int [nums.length];
        int idx = 0;
        for(int num : nums){
            if(num % 2 == 0) output[idx++] = num;
        }
        for(int num : nums){
            if(num % 2 == 1) output[idx++] = num;
        }
        return output;
    }
}