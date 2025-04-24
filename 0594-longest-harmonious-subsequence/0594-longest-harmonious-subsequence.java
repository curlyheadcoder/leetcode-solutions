class Solution {
    public int findLHS(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxLen = 0;
        // Count frequency of each number
        for(int num : nums){
            map.put(num, map.getOrDefault(num,0)+1);
        }
        // Check for each number if num+1 exists
        for(int key : map.keySet()){
            if(map.containsKey(key+1)){
                maxLen = Math.max(maxLen, map.get(key) + map.get(key+1));
            }
        }
        return maxLen;
    }
}