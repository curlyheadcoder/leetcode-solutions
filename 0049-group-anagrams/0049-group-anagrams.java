class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String s : strs){
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            String sorted = new String(charArray);
            map.computeIfAbsent(sorted, k -> new ArrayList<>()).add(s);
        }
        return new ArrayList<>(map.values());
    }
}