class Solution {
public:
    int findLHS(vector<int>& nums) {
        unordered_map<int, int> map;
        int maxLen = 0;

        // Count frequency of each number
        for (int num : nums) {
            map[num]++;
        }

        // Check for each number if num + 1 exists
        for (auto& pair : map) {
            int key = pair.first;
            if (map.count(key + 1)) {
                maxLen = max(maxLen, map[key] + map[key + 1]);
            }
        }

        return maxLen;
    }
};