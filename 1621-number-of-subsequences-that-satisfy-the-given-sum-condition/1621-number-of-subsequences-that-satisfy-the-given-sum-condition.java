class Solution {
    private static final long MOD = 1_000_000_007L;

    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int[] pow2 = new int[n];
        pow2[0] = 1;

        for (int i = 1; i < n; i++) {
            pow2[i] = (int)((pow2[i - 1] * 2L) % MOD);  // cast after long calc
        }

        int left = 0, right = n - 1;
        int res = 0;

        while (left <= right) {
            if (nums[left] + nums[right] <= target) {
                res = (int)((res + pow2[right - left]) % MOD);  // cast here too
                left++;
            } else {
                right--;
            }
        }

        return res;
    }
}