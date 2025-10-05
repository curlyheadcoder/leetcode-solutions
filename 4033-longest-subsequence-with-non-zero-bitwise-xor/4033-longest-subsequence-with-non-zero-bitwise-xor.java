class Solution {
    public int longestSubsequence(int[] nums) {
        int [] dummy = nums;
        int n = dummy.length;
        if(n == 0) return 0;
        int total = 0;
        boolean hasNonZero = false;
        for(int x : dummy){
            total ^= x;
            if(x != 0) hasNonZero = true;
        }
        if(total != 0) return n;
        if(hasNonZero) return n-1;
        else return 0;
    }
}