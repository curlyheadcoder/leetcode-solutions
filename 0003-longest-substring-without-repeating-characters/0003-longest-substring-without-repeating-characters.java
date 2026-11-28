class Solution {
    public int lengthOfLongestSubstring(String s) {
        int start = 0, end = 0;
        int n = s.length();
        HashSet<Character> set = new HashSet<>();
        int maxLen = Integer.MIN_VALUE;
        int len = 0;
        while(end < n){
            char c = s.charAt(end);
            if(set.contains(c)){
                while(start < end && set.contains(c)){
                    set.remove(s.charAt(start));
                    start++;
                }
            }
            set.add(c);
            maxLen = Math.max(maxLen, end-start+1);
            end++;
        }
        return (maxLen == Integer.MIN_VALUE) ? 0 : maxLen;
    }
}