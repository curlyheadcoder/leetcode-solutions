class Solution {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        int n = words.length;
        List<String> ans = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(i == 0 || groups[i] != groups[i-1]){ // new group started, so pick the first element 
                ans.add(words[i]);
            }
        }
        return ans;
    }
}