class Solution {       // Using HashMap
    public int lengthOfLongestSubstring(String s) {
        int winStart = 0, winEnd = 0;
        int n = s.length();
        HashMap<Character,Integer> map = new HashMap<>();
        int maxLen = Integer.MIN_VALUE;
        while(winEnd < n){
            char ch = s.charAt(winEnd);
            if(map.containsKey(ch) && map.get(ch) >= winStart){
                winStart = map.get(ch)+1;
            }
            map.put(ch,winEnd);
            maxLen = Math.max(maxLen, winEnd-winStart+1);
            winEnd++;
        }

        return (maxLen == Integer.MIN_VALUE) ? 0 : maxLen;

    }
}