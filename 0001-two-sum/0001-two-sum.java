class Solution {
    public int[] twoSum(int[] nums, int target) {
        // 2 7 11 15   target = 9
        // o/p ---> 0, 1  ---> indices
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int diff = target - nums[i];
            if(map.containsKey(diff)){
                return new int [] {map.get(diff), i};
            }
            map.put(nums[i], i);
        }
        return new int [] {-1,-1};
    }
}