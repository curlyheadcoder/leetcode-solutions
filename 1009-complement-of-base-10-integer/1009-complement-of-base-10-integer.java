class Solution {
    public int bitwiseComplement(int n) {
        // Base case:
        if(n == 0) return 1;

        // Step1: FInd the num of bits
        // Step2: Create a mask with all 1s
        int mask = 0;
        int temp = n;
        while(temp > 0){
            mask = (mask << 1) | 1;
            temp >>= 1;
        }
        // Step3: XOR num with mask
        return n ^ mask;
    }
}