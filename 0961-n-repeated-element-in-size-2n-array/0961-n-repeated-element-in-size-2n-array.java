class Solution {
    public int repeatedNTimes(int[] nums) {
        int[] freq = new int[10001];
        
        for (int num : nums) {
            freq[num]++;
            if (freq[num] > 1) // all other elements appear exactly once
                return num;
        }
        
        return -1;
    }
}