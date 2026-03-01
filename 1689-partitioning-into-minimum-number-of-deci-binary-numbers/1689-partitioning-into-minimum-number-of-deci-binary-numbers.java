class Solution {
    public int minPartitions(String n) {
        int maxDigit = 0;
        for(char ch : n.toCharArray()){
            int digit = ch - '0';
            maxDigit = Math.max(maxDigit, digit);
            // Early stop optimization
            if(maxDigit == 9) return 9;
        }
        return maxDigit;
    }
}