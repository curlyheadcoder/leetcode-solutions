class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> fmap = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int diff = target - nums[i];
            if(fmap.containsKey(diff)){
                return new int []{i, fmap.get(diff)};
            }
            fmap.put(nums[i], i);
        }
        return new int [] {-1,-1};
    }
}