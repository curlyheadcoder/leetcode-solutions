class Solution {
    public int minimumOneBitOperations(int n) {
        int mask = n;
        while(mask != 0){
            mask >>= 1;
            n ^= mask;
        }
        return n;
    }
}