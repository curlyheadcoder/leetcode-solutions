class Solution {
    public int makeTheIntegerZero(int num1, int num2) {
        for(long k = 1; k <= 60; k++){
            long targetSum = (long) num1 - k * (long) num2;
            if(targetSum < 0) continue;
            int bits = Long.bitCount(targetSum);
            if(bits <= k && k <= targetSum){
                return (int) k;
            }
        }
        return -1;
    }
}