class Solution {
    public int longestBalanced(int[] nums) {
        int n = nums.length;
        int maxLen = 0;
        for(int i = 0; i < n; i++){
            Map<Integer, Integer> freq = new HashMap<>();
            int disEven = 0;
            int disOdd = 0;
            for(int j = i; j < n; j++){
                int num = nums[j];
                freq.put(num, freq.getOrDefault(num, 0)+1);
                if(freq.get(num) == 1){   // first time seen
                    if(num % 2 == 0) disEven++;
                    else disOdd++;
                }
                if(disEven == disOdd){
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }
        return maxLen;
    }
}