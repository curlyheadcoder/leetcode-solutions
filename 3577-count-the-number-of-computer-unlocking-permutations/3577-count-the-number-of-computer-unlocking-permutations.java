class Solution {
    private static final long MOD = 1_000_000_007L;
    public int countPermutations(int[] complexity) {
        int n = complexity.length;
        if(n <= 1) return 1;
        int minOther = Integer.MAX_VALUE;
        for(int i = 1; i < n; i++){
            if(complexity[i] < minOther) minOther = complexity[i];
        }
        if(!(complexity[0] < minOther)) return 0;

        long fact = 1;
        for(int i = 1; i <= n-1; i++){
            fact = (fact * i) % MOD;
        }
        return (int) fact;
    }
}