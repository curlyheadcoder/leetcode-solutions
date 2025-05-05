class Solution {
    static int mod = (int) 1e9 + 7;
    public int numTilings(int n) {
        long f0 = 1, f1 = 0, f2 = 0, f3 = 0;
        for(int i = 1; i <= n; i++){
            long newF0 = (f0 + f1 + f2 + f3) % mod;
            long newF1 = (f2 + f3) % mod;
            long newF2 = (f1 + f3) % mod;
            long newF3 = f0;

            f0 = newF0;
            f1 = newF1;
            f2 = newF2;
            f3 = newF3;
        }

        return (int) f0;
    }
}