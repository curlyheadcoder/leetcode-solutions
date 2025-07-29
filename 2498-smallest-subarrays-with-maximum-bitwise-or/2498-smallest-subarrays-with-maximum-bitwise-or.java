class Solution {
    public int[] smallestSubarrays(int[] nums) {
        int n = nums.length;
        int [] ans = new int [n];
        int [] lastSeen = new int [32];  // last seen index of each bit(0 to 31)

        for(int i = 0; i < 32; i++){
            lastSeen [i] = -1;   // initialize all bits as not seen
        }

        for(int i = n - 1; i >= 0; i--){
            // Update last seen positions for bits set in nums[i]
            for(int bit = 0; bit < 32; bit++){
                if(((nums[i] >> bit) & 1) == 1){
                    lastSeen[bit] = i;
                }
            }
            // Find the farthest indedx we need to go to include all bits
            int maxReach = i;
            for(int bit = 0; bit < 32; bit++){
                if(lastSeen[bit] != -1){
                    maxReach = Math.max(maxReach, lastSeen[bit]);
                }
            }
            ans[i] = maxReach - i + 1;
        }
        return ans;
    }
}