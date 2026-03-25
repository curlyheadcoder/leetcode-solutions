class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int n = s.length();
        int left = 0;
        int max = 0;
        for(int right = 0; right < n; right++){
            char c = s.charAt(right);
            if(map.containsKey(c)){
                left = Math.max(map.get(c) + 1, left);
            }
            map.put(c, right);
            max = Math.max(max, right - left + 1);
        }
        return max;
    }
}