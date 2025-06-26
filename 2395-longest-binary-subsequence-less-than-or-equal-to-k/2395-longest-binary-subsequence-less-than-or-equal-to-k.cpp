class Solution {
public:
    int longestSubsequence(string s, int k) {
        int n = s.length();
        long powerValue = 1;  // 2^0
        int len = 0;
        for(int i = n - 1; i >= 0; i--){
            if(s[i] == '0') len++;
            else if(powerValue <= k){
                k -= powerValue;
                len++;
            }
            if(powerValue <= k){
                powerValue <<= 1;    //(powerValue * 2)
            }
        }
        return len;
    }
};