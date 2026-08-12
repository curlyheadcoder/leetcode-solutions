class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int maxLen = 0;
        for(int i = 0; i < nums.length; i++){
            HashMap<Integer, Integer> map = new HashMap<>();
            for(int j = i; j < nums.length; j++){
                int freq = map.getOrDefault(nums[j], 0) + 1;
                map.put(nums[j], freq);
                // if frequency becomes greater than k
                // this subarray is no longer a good array
                if(freq > k) break;
                maxLen = Math.max(maxLen, j-i+1);  // our subarray is still valid
            }
        }
        return maxLen;
    }
}