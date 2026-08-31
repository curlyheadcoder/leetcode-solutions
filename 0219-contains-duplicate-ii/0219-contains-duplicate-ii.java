class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> fmap = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(fmap.containsKey(nums[i])){
                int prevIdx = fmap.get(nums[i]);
                if(i - prevIdx <= k){
                    return true;
                }
            }
            fmap.put(nums[i], i);
        }
        return false;
    }
}