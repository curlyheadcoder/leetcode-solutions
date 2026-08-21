class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        HashMap<Character, Integer> fMap = new HashMap<>();
        for(char ch : s.toCharArray()){
            fMap.put(ch, fMap.getOrDefault(ch, 0)+1);
        }
        for(char ch : t.toCharArray()){
            if(!fMap.containsKey(ch)) return false;
            fMap.put(ch, fMap.get(ch) - 1);
            if(fMap.get(ch)==0) fMap.remove(ch);
        }
        return fMap.isEmpty();
    }
}