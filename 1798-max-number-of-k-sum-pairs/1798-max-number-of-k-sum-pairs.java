class Solution {
    public int maxOperations(int[] nums, int k) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        int count = 0;
        for(int num : nums){
            int complement = k - num;
            if(freqMap.getOrDefault(complement, 0) > 0){
                count++;
                freqMap.put(complement, freqMap.get(complement) -1);
            }else{
                freqMap.put(num, freqMap.getOrDefault(num, 0) +1);
            }
        }
        return count;
    }
}