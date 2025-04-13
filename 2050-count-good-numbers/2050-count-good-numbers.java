class Solution {
    private long MOD = 1000000007;
    public int countGoodNumbers(long n) {
        return (int)((helper(5, (n+1)/2) * helper(4, n/2)) % MOD);
    }
    private long helper(int x, long y){
        long ret = 1;
        long mul = x;
        while(y > 0){
            if(y % 2 == 1){
                ret = (ret * mul) % MOD;
            }
            mul = (mul * mul) % MOD;
            y /= 2;
        }
        return ret;
    }
}