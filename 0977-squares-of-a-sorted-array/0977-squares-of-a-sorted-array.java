class Solution {
    public int[] sortedSquares(int[] nums) {
        int [] res = new int [nums.length];
        int i = 0, j = nums.length-1;
        int k = nums.length-1;    // result 
        while(k >= 0){
            int a = nums[i] * nums[i];
            int b = nums[j] * nums[j];
            if(a > b){
                res[k] = a;
                i++; 
            }else{
                res[k] = b;
                j--;
            }
            k--;
        }
        return res;
    }
}