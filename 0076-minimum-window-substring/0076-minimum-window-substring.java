class Solution {
    public String minWindow(String s, String t) {
        if(s.length()< t.length()) return "";
        // Frequency map for t
        int [] targetFreq = new int [256];
        for(char c : t.toCharArray()){
            targetFreq[c]++;
        }

        int start = 0, end = 0, minStart = 0, minLength = Integer.MAX_VALUE;
        int required = t.length(), formed = 0;
        int [] windowFreq = new int [256];
        while(end < s.length()){
            char c = s.charAt(end);
            windowFreq [c]++;
            if(windowFreq[c] <= targetFreq[c]){
                formed++;
            }
            // If the window is valid, try to minimize it
            while(start <= end && formed == required){
                if(end - start + 1 < minLength){
                    minLength = end - start + 1;
                    minStart = start;
                }
                // shrink the window
                char startChar = s.charAt(start);
                windowFreq[startChar]--;
                if(windowFreq[startChar] < targetFreq[startChar]){
                    formed--;
                }
                start++;
            }
            // expand the window
            end++;
        }

        return minLength == Integer.MAX_VALUE? "": s.substring(minStart, minStart + minLength);
    }
}