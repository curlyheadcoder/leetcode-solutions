class Solution {
    public int trailingZeroes(int n) {
        int count = 0, pow =5;
        while(n >= 5){
            n /= 5;
            count += n;
        }
        return count;
    }
}