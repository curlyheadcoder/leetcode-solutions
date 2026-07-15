class Solution {
    private int gcd(int a, int b){
        if(b == 0) return a;
        return gcd(b, a % b);
    }
    public int gcdOfOddEvenSums(int n) {
        int oSum = 0, eSum = 0;
        for(int i = 1; i <= n; i++){
            oSum += (2 * i -1);
            eSum += (2 * i);
        }
        return gcd(oSum, eSum);
    }
}
