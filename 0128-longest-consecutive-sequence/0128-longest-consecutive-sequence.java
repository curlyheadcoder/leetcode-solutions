class Solution {
    public int longestConsecutive(int[] nums) {
        int ans = 0;
        Map<Integer, Boolean> exploredMap = new HashMap<>();
        for(int num : nums){
            exploredMap.put(num, Boolean.FALSE);
        }
        for(int num : nums){
            int currLen = 1;
            int nextNum = num+1;
            while(exploredMap.containsKey(nextNum) && exploredMap.get(nextNum) == false){
                currLen++;
                exploredMap.put(nextNum, Boolean.TRUE);
                nextNum++;
            }
            int prevNum = num-1;
            while(exploredMap.containsKey(prevNum) && !exploredMap.get(prevNum)){
                currLen++;
                exploredMap.put(prevNum, Boolean.TRUE);
                prevNum--;
            }
            ans = Math.max(ans, currLen);
        }
        return ans;
    }
}