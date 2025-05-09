class Solution {

    private static final long MOD = 1_000_000_007;

    public int countBalancedPermutations(String num) {
        int n = num.length();
        // Count frequency of each digit 0-9
        int [] cnt = new int [10];
        int totalSum = 0;

        // Step 2: Count digit frequencies and calculate total sum
        for(char ch : num.toCharArray()){
            int d = ch - '0';
            cnt[d]++;
            totalSum += d;
        }
        // Step 3: Early exit if total is odd
        if(totalSum % 2 != 0) return 0;
        int target = totalSum/2;

        // Step 4: maxOdd = positions available for odd indices
        int maxOdd = (n + 1) / 2;

        // Step 5: Precompute combinations C(n, k) using Pascal's Triangle
        long [][] comb = new long [maxOdd+1][maxOdd+1];
        for(int i = 0; i <= maxOdd; i++){
            comb[i][0] = comb[i][i] = 1;
            for(int j = 1; j < i; j++){
                comb[i][j] = (comb[i-1][j] + comb[i-1][j-1]) % MOD;
            }
        }  
        // Step 6 : Initialize DP table
        long [][] f = new long [target+1][maxOdd+1];
        f[0][0] = 1; // base case: 0 sum with 0 odd digits

        int prefixDigitCount = 0;
        int prefixDigitSum = 0;

        // Step 7: Loop through digits 0-9
        for(int d = 0; d <= 9; d++){
            int digitCount = cnt[d];
            if(digitCount == 0) continue;

            prefixDigitCount += digitCount;
            prefixDigitSum += d * digitCount;

            // Step 8: Traverse possible counts of digits used so far

            for(int oddCnt = Math.min(prefixDigitCount, maxOdd); oddCnt >= Math.max(0, prefixDigitCount - (n-maxOdd)); oddCnt--){
                int evenCnt = prefixDigitCount - oddCnt;
                // Traverse current possible sums
                for(int currSum = Math.min(prefixDigitSum, target); currSum >= Math.max(0, prefixDigitSum - target); currSum--){
                    long res = 0;

                    // Step 9: Try placing j copies of digit d at odd positions 
                    for(int j = Math.max(0, digitCount - evenCnt); j <= Math.min(digitCount, oddCnt) && d * j <= currSum; j++){
                        int k = digitCount - j;  // Remaining go to even
                        long ways = (comb[oddCnt][j] * comb[evenCnt][k]) % MOD;

                        // Multiply ways with previous state 
                        res = (res + ways * f[currSum - d * j][oddCnt - j]) % MOD;
                    }
                    f[currSum][oddCnt] = res;
                }
            }
        } 
        return (int) f[target][maxOdd];
    }
}