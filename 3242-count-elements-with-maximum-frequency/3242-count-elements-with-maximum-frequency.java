class Solution {
    public int maxFrequencyElements(int[] nums) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        int maxFreq = 0;
        for(int num : nums){
            int count = freqMap.getOrDefault(num, 0) + 1;
            freqMap.put(num, count);
            maxFreq = Math.max(maxFreq, count);
        }
        int res = 0;
        for(int val : freqMap.values()){
            if(val == maxFreq){
                res += val;
            }
        }
        return res;
    }
}