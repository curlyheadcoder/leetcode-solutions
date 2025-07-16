class Solution {
    public int maximumLength(int[] nums) {
        int n = nums.length;
        int evenCount = 0, oddCount = 0;

        for(int num : nums){
            if(num % 2 == 0){
                evenCount++;
            }else{
                oddCount++;
            }
        }
        int parity = nums[0] % 2;    // for first element of the array
        int alternating = 1;        // length of alternating parity numbers sequence.

        for(int i = 1; i < n; i++){
            int currParity = nums[i] % 2;
            if(currParity != parity){     // alternating parity
                alternating++;
                parity = currParity;
            }
        }
        return Math.max(Math.max(evenCount, oddCount), alternating);
    }
}