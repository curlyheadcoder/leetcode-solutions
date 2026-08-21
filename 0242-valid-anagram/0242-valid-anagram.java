class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        HashMap<Character,Integer> map1 = new HashMap<>();
        HashMap<Character,Integer> map2 = new HashMap<>();
        for(char ch1 : s.toCharArray()){
            map1.put(ch1, map1.getOrDefault(ch1, 0) + 1);
        }
        for(char ch2 : t.toCharArray()){
            map2.put(ch2, map2.getOrDefault(ch2, 0) + 1);
        }
        return map1.equals(map2);
    }
}