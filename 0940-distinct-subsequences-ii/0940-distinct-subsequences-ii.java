class Solution {
    public int distinctSubseqII(String s) {
        final long MOD = 1_000_000_007L;
        long [] last = new long [26];
        long total = 0;
        for(char ch : s.toCharArray()){
            int index = ch - 'a';
            long newSubsequences = (total + 1) % MOD;
            total = (total + newSubsequences - last[index] + MOD) % MOD;
            last[index] = newSubsequences;
        }
        return (int) total;
    }
}