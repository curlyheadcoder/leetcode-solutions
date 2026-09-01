class Solution {
    public int firstUniqChar(String s) {
        Map<Character, Integer> fmap = new HashMap<>();
        // Count frequency
        for(char ch : s.toCharArray()){
            fmap.put(ch, fmap.getOrDefault(ch, 0)+1);
        }
        // Find first unique
        for(int i = 0; i < s.length(); i++){
            if(fmap.get(s.charAt(i)) == 1){
                return i;
            }
        }
        return -1;
    }
}