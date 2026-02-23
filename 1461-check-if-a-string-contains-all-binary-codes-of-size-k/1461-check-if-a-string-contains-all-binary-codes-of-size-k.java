class Solution {
    public boolean hasAllCodes(String s, int k) {
        int needed = 1 << k;   // 2^k
        Set<String> seen = new HashSet<>();
        for(int i = 0; i <= s.length() - k; i++){
            String sub = s.substring(i, i+k);
            seen.add(sub);
            // Early exit optimization
            if(seen.size() == needed){
                return true;
            }
        }
        return seen.size() == needed;
    }
}