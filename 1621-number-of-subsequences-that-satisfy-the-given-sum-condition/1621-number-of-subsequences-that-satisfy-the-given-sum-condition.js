/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
var numSubseq = function(nums, target) {
    const MOD = 1_000_000_007;
    nums.sort((a, b) => a - b);
    const n = nums.length;

    // Precompute powers of 2 modulo MOD
    const pow2 = Array(n).fill(1);
    for (let i = 1; i < n; i++) {
        pow2[i] = (pow2[i - 1] * 2) % MOD;
    }

    let res = 0;
    let left = 0, right = n - 1;

    while (left <= right) {
        if (nums[left] + nums[right] <= target) {
            res = (res + pow2[right - left]) % MOD;
            left++;
        } else {
            right--;
        }
    }

    return res;
};