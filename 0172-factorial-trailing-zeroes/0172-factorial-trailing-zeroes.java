class Solution {
    public int trailingZeroes(int n) {
        int zeroCount = 0;
        while(n >= 5){
            n /= 5;
            zeroCount += n;
        }
        return zeroCount;
    }
}