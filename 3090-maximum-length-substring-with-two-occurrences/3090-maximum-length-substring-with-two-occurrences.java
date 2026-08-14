class Solution {
    public int maximumLengthSubstring(String s) {
        int maxLen = 0;
        int n = s.length();
        for(int i = 0; i < n; i++){
            int [] arr = new int [26];
            for(int j = i; j < n; j++){
                if(++arr[s.charAt(j) - 'a'] == 3) break;
                maxLen = Math.max(maxLen, j-i+1);
            }
        }
        return maxLen;
    }
}