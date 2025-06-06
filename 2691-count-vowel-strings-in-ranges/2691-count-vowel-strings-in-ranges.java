class Solution {
    private boolean isVowel(char c){
        return "aeiou".indexOf(c) != -1;
    }
    public int[] vowelStrings(String[] words, int[][] queries) {
        int n = words.length;
        int [] prefixSum = new int [n+1];
        for(int i = 0; i < n; i++){
            String word = words[i];
            char first = word.charAt(0);
            char last = word.charAt(word.length()-1);
            prefixSum[i+1] = prefixSum[i] + (isVowel(first) && isVowel(last) ? 1 : 0);
        }
        int [] ans = new int [queries.length];
        for(int i = 0; i < queries.length; i++){
            int l = queries[i][0];
            int r = queries[i][1];
            ans[i] = prefixSum[r+1] - prefixSum[l];
        }
        return ans;
    }
}