class Solution {
    public int countPalindromicSubsequence(String s) {
        int [] fo = new int [26], lo = new int [26];
        Arrays.fill(fo, Integer.MAX_VALUE);
        for(int i = 0; i < s.length(); i++){
            fo[s.charAt(i) - 'a'] = Math.min(fo[s.charAt(i) - 'a'], i);
            lo[s.charAt(i) - 'a'] = i;
        }
        int ans = 0;
        for(int i = 0; i < 26; i++){
            int f = fo[i], l = lo[i];
            Set<Character> unique = new HashSet<>();
            if(f < l){
                for(int j = f + 1; j < l; j++){
                    unique.add(s.charAt(j));
                }
            }
            ans += unique.size();
        }
        return ans;
        }
    
}