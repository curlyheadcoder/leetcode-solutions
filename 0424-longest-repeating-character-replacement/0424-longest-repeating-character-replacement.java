class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int [] count = new int [26];
        int maxCount = 0;
        int maxLen = 0;
        int start = 0;
        for(int end = 0; end < n; end++){
            
            maxCount = Math.max(maxCount, ++count[s.charAt(end) - 'A']);
            while((end - start + 1) - maxCount > k){
                count[s.charAt(start) - 'A']--;
                start++;
            }
            maxLen = Math.max(maxLen, (end - start + 1));
        }
        return maxLen;
    }
}