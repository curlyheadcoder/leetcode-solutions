class Solution {
    public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
        int n = words.length;
        int [] dp = new int [n];
        int [] prev = new int [n];
        Arrays.fill(dp, 1);
        Arrays.fill(prev, -1);
        int maxLen = 1, lastIndex = 0;
        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++){
                if(groups[i] != groups[j] && 
                    words[i].length() == words[j].length()
                    && hammingDistance(words[i], words[j]) == 1
                    && dp[j] + 1 > dp[i]){
                        dp[i] = dp[j] + 1;
                        prev[i] = j;
                    }
            }
            if(dp[i] > maxLen){
                maxLen = dp[i];
                lastIndex = i;
            }
        }
        LinkedList<String> res = new LinkedList<>();
        while(lastIndex != -1){
            res.addFirst(words[lastIndex]);
            lastIndex = prev[lastIndex];
        }
        return res;
    }
    private int hammingDistance(String a, String b){
        int dist = 0;
        for(int i = 0; i < a.length(); i++){
            if(a.charAt(i) != b.charAt(i)) dist++;
        }
        return dist;
    }
}