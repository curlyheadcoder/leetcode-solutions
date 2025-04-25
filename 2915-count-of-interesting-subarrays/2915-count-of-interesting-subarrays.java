class Solution {
    public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
         long ans = 0;
         int pc = 0;
         Map<Integer, Long> map = new HashMap<>();
         map.put(0, 1L);
         for(int num : nums)
         {
            if(num % modulo == k) pc += 1;
            int mod = pc % modulo;
            int target = mod - k;
            if(target < 0) target += modulo;
            ans += map.getOrDefault(target, 0L);
            map.put(mod, map.getOrDefault(mod, 0L)+1);
         }
         return ans;
    }
}