class Solution {
    public boolean hasAlternatingBits(int n) {
        // Step 1. XOR n with n right shifted by 1
        int x = n ^ (n >> 1);
        // Step 2. check if x is of form 111....1111
        // for such numbers : x & (x + 1) == 0
        return (x & (x + 1)) == 0;
    }
}