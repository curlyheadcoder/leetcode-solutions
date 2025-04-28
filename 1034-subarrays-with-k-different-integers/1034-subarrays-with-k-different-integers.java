class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        // Exactly K different = AtMost(K) - AtMost(K-1)
        return atMost(nums, k) - atMost(nums, k-1);
    }
    private static int atMost(int [] nums, int k){
        int left = 0, result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int right = 0; right < nums.length; right++){
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            if(map.get(nums[right]) == 1){
                k--;
            }
            while(k < 0){
                map.put(nums[left], map.get(nums[left]) - 1);
                if(map.get(nums[left]) == 0){
                    k++;
                }
                left++;
            }

            result += right - left + 1;
        }
        return result;
    
    }
}