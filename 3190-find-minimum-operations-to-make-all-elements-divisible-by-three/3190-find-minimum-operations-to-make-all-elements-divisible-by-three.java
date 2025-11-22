class Solution {
    public int minimumOperations(int[] nums) {
        int count = 0;
        for(int num : nums){
            int a = num % 3;
            int b = 3 - a;
            count += Math.min(a, b);
        }
        return count;
    }
}