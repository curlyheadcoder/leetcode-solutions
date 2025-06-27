class Solution {
public:
    string res = "";

    // Check if 'curr' repeated k times is a subsequence of 's'
    bool isSubsequence(string &s, string &curr, int k) {
        int i = 0, j = 0, count = 0;
        int n = s.length(), m = curr.length();

        while (i < n) {
            if (s[i] == curr[j]) {
                j++;
                if (j == m) {
                    count++;
                    j = 0;
                    if (count == k) return true;
                }
            }
            i++;
        }
        return false;
    }

    void backtracking(string &s, string &curr, vector<bool>& canUse, vector<int>& requiredFreq, int k, int maxLen) {
        if (curr.length() > maxLen) return;

        if (((curr.length() > res.length()) || (curr.length() == res.length() && curr > res)) && isSubsequence(s, curr, k)) {
            res = curr;
        }

        for (int i = 25; i >= 0; i--) { // start from 'z' for lexicographically larger
            if (canUse[i] && requiredFreq[i] > 0) {
                curr.push_back('a' + i);
                requiredFreq[i]--;
                backtracking(s, curr, canUse, requiredFreq, k, maxLen);
                requiredFreq[i]++;
                curr.pop_back();
            }
        }
    }

    string longestSubsequenceRepeatedK(string s, int k) {
        int n = s.length();
        int freq[26] = {};
        for (char &ch : s) {
            freq[ch - 'a']++;
        }

        vector<bool> canUse(26, false);
        vector<int> requiredFreq(26, 0);
        for (int i = 0; i < 26; i++) {
            if (freq[i] >= k) {
                canUse[i] = true;
                requiredFreq[i] = freq[i] / k; // at most this many times can be used
            }
        }

        int maxLen = n / k;
        string curr;
        backtracking(s, curr, canUse, requiredFreq, k, maxLen);
        return res;
    }
};
