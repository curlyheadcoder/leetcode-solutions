class Solution {
    public int countCompleteSubarrays(int[] nums) {
        HashSet<Integer> uniqueSet = new HashSet<>();
        for(int num : nums){
            uniqueSet.add(num);
        }
        int distinctCount = uniqueSet.size();
        HashMap<Integer, Integer> windowCounts = new HashMap<>();
        int left = 0, right = 0, completeSubArrays = 0;
        while(right < nums.length){
            windowCounts.put(nums[right], windowCounts.getOrDefault(nums[right], 0)+1);
            while(windowCounts.size() == distinctCount){
                completeSubArrays += nums.length - right;
                windowCounts.put(nums[left], windowCounts.get(nums[left])-1);
                if(windowCounts.get(nums[left]) == 0){
                    windowCounts.remove(nums[left]);
                }
                left++;
            }
            right++;
        }
        return completeSubArrays;
    }
}