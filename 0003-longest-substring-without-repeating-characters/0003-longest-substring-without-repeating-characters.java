class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i = 0, j = 0;
        int n = s.length();
        HashSet<Character> set = new HashSet<>();
        int maxLen = 0, currLen = 0;
        while(j < n){
            char c = s.charAt(j);
            if(set.contains(c)){
                while(i < j && set.contains(c)){
                    set.remove(s.charAt(i));
                    i++;
                }
            }
            set.add(c);
            maxLen = Math.max(maxLen, j - i + 1);
            j++;
        }
        return maxLen;
    }
}