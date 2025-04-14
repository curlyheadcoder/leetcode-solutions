class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int evenSum = 0;
        int [] res = new int [queries.length];
        // Initial sum of even numbers
        for(int num : nums){
            if(num % 2 == 0){
                evenSum += num;
            }
        }
        // Process each query
        for(int i = 0; i < queries.length; i++){
            int value = queries[i][0];
            int idx = queries[i][1];
            // If original number is even, remove it from sum
            if(nums[idx] % 2 == 0){
                evenSum -= nums[idx];
            }
            // Update the value
            nums[idx] += value;
            // If update number is even, add it to sum
            if(nums[idx] % 2 == 0){
                evenSum += nums[idx];
            }
            res[i] = evenSum;
        }
        return res;
    }
}