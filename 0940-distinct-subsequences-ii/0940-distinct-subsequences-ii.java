class Solution {
    public int distinctSubseqII(String s) {
        final long MOD = 1_000_000_007L;
        // last[c] = dp value before the previous occurence of character c
        long [] last = new long[26];
        // Initially only the empty subsequence exists
        long dp = 1;
        for(char ch : s.toCharArray()){
            int index = ch - 'a';
            long newDp = (2 * dp - last[index] + MOD) % MOD;
            // store the old dp value for this character
            last[index] = dp;
            dp = newDp;
        }
        // Remove the empty subsequence
        return (int)((dp - 1 + MOD) % MOD);
    }
}