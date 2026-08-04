class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int diff = target - nums[i];
            if(freqMap.containsKey(diff)){
                return new int [] {i, freqMap.get(diff)};
            }
            freqMap.put(nums[i], i);
        }
        return new int [] {-1, -1};
    }
}