class Solution {
    public boolean isPowerOfThree(int n) {
        int maxPower = (int) Math.pow(3,19);
        return n>0 && (maxPower % n == 0);
    }
}