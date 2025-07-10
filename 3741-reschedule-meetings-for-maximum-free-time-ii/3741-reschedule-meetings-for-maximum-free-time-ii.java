class Solution {
    public int maxFreeTime(int eventTime, int[] startTime, int[] endTime) {
        int n = startTime.length;
        // Step 1: Create a boolean Array to mark meetings that can be moved
        boolean [] movable = new boolean [n];

        // Step 2: Initialize max gaps from both left and right sides
        int maxLeftGap = 0;
        int maxRightGap = 0;

        // Step 3: Forward pass (left to right) to mark meetings that can be moved earlier 
        for(int i = 0; i < n; i++){
            int duration = endTime[i] - startTime[i];
            if(duration <= maxLeftGap){
                movable[i] = true;
            }
            // Update maxLeftGap with current gap before this meeting 
            if(i == 0){
                maxLeftGap = startTime[i];   // gap from 0 to start of first meeting
            }else{
                maxLeftGap = Math.max(maxLeftGap, startTime[i] - endTime[i-1]);
            }
        }
        // Ste 4: Backward pass (right to left) to mark meetings that can be moved later
        for(int i = n - 1; i >= 0; i--){
            int duration = endTime[i] - startTime[i];
            if(duration <= maxRightGap){
                movable[i] = true;
            }
            // Update maxRightGap with current gap after this meeting
            if(i == n - 1){
                maxRightGap = eventTime - endTime[i];   // gap from end of last meeting to eventTime
            }else{
                maxRightGap = Math.max(maxRightGap, startTime[i+1] - endTime[i]);
            }
        }
        // Step 5: Now, try removing or keeping each meeting, and compute the max free time
        int maxFreeTime = 0;

        for(int i = 0; i < n; i++){
            // Define the gap between neighboring meetings
            int left = (i == 0) ? 0 : endTime[i-1];
            int right = (i == n - 1) ? eventTime : startTime[i + 1];

            if(movable[i]){
                // Step 6: If this meeting can be moved away, full gap is available
                maxFreeTime = Math.max(maxFreeTime, right - left);
            }else{
                // Step 7: If not movable, we subtract its duration from the gap
                int duration = endTime[i] - startTime[i];
                maxFreeTime = Math.max(maxFreeTime, (right - left - duration));
            }
        }
        return maxFreeTime;
    }
}