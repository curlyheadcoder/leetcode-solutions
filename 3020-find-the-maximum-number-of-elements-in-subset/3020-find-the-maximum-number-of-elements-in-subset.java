class Solution {
    public int maximumLength(int[] nums) {
        Map<Long, Integer> freq = new HashMap<>();
        for(int num : nums){
            freq.put((long) num, freq.getOrDefault((long) num, 0)+1);
        }
        int max = 0;
        for(long num : freq.keySet()){
            if(num == 1L){
                int count = freq.get(num);
                if(count % 2 == 0) count--; // Only odd count is valid for symmetry
                max = Math.max(max, count);
                continue; 
            }

            long val = num;
            int len = 0;
            while(freq.getOrDefault(val, 0) >= 2){
                len += 2;
                val *= val;
                if(val > 1e18) break;    // avoid overflow
            }
            if(freq.getOrDefault(val,0) >= 1){
                len++;
            }else{
                len--;
            }
            max = Math.max(max, len);
        }
        return max;
    }
}