class Solution {
    public int maxDifference(String s, int k) {
        int n = s.length();
        int ans = Integer.MIN_VALUE;
        // TODO 1: Try all the combinations of two different digits between '0' and '4'
        for(char a = '0'; a <= '4'; ++a){
            for(char b = '0'; b <= '4'; ++b){
                if(a == b) continue;     // Skip if both characters are the same
                // TODO 2: Initialize state tracking variables
                int [] best = new int [4];    // Stores the best (min) values for each parity stage
                Arrays.fill(best, Integer.MAX_VALUE);   // Initialize to MAX to represent "no value yet"
                int cnt_a = 0, cnt_b = 0;    // Total Counts from start to current positions (right)
                int prev_a = 0, prev_b = 0;  // Prefix counts from start to 'left' (excluded window)
                int left = -1;              // Left pointer (start of the window)

                // TODO 3: Slide the right pointer across the String
                for(int right = 0; right < n; ++right){
                    // Count current character as 'a' or 'b' if it matches
                    if(s.charAt(right) == a) cnt_a++;
                    if(s.charAt(right) == b) cnt_b++;
                    // TODO 4: Shrink the window from the left while conditions hold
                    while((right - left) >= k && (cnt_b - prev_b) >= 2){
                        // Compute the current prefix parity status
                        int leftStatus = getStatus(prev_a, prev_b);
                        // Update the best value for this parity state
                        best[leftStatus] = Math.min(best[leftStatus], prev_a - prev_b);
                        // Slide left pointer forward and update prefix counts
                        left++;
                        if(s.charAt(left) == a) prev_a++;
                        if(s.charAt(left) == b) prev_b++; 
                    }
                    // TODO 5: Check if we can form a valid window with opposite a-parity
                    int rightStatus = getStatus(cnt_a, cnt_b);
                    // XOR with 0b10 flips a's parity, keeps b's parity the same
                    int flippedStatus = rightStatus ^ 0b10;
                    // If we have seen such a prefix before, try to update the answer
                    if(best[flippedStatus] != Integer.MAX_VALUE){
                        int currentDiff = (cnt_a - cnt_b) - best[flippedStatus];
                        ans = Math.max(ans, currentDiff);
                    }
                }
            }
        }
        return ans;        // Return the best difference found
    }
    // TODO 6: Helper to encode parity of a and b into a 2-bit integer
    // Bit 1: parity of a (0 = even, 1 = odd)
    // Bit 2: parity of b (0 = even, 1 = odd)
    private int getStatus(int cnt_a, int cnt_b){
        return ((cnt_a & 1) << 1) | (cnt_b & 1);
    }
}