class Solution {
    public long countSubarrays(int[] nums, int k) {
        int max = -1;
        for (int num : nums) {
            max = Math.max(max, num);
        }

        int left = 0;
        int currK = 0;
        long res = 0; 

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == max) {
                currK++;
            }
            while (currK >= k) {
                if (nums[left] == max) {
                    currK--;
                }
                left++;
            }
            res += left;
        }

        return res;
    }
}
