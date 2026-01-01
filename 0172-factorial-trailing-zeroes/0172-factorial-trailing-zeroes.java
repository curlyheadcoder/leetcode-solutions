class Solution {
    public int trailingZeroes(int n) {
        int res = 0;
        int pow = 5;
        while(n >= pow){
            res = res + (n/pow);
            pow *= 5;
        }
        return res;
    }
}