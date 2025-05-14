class Solution {
    private static final int MOD = 1_000_000_007;
    public int lengthAfterTransformations(String s, int t, List<Integer> nums) {
        int [] temp = new int [26];
        for(int i = 0; i < 26; i++){
            temp[i] = nums.get(i);
        }
        // Build Transition matrix
        long [][] transition = new long [26][26];
        for(int i = 0; i < 26; i++){
            for(int j = 1; j <= temp[i]; j++){
                int next = (i+j) % 26;
                transition[i][next] = (transition[i][next] + 1) % MOD;
            }
        }
        long [][] transT = matrixPower(transition, t);
        long [] initial = new long [26];
        for(char ch : s.toCharArray()){
            initial[ch - 'a']++;
        }
        long res = 0;
        for(int i = 0; i < 26; i++){
            long sum = 0;
            for(int j = 0; j < 26; j++){
                sum = (sum + transT[j][i] * initial[j]) % MOD;
            }
            res = (res + sum) % MOD;
        }
        return (int) res;
    }
    private long [][] matrixMultiply(long [][] A, long [][] B){
        long [][] res = new long [26][26];
        for(int i = 0; i < 26; i++){
            for(int k = 0; k < 26; k++){
                for(int j = 0; j < 26; j++){
                    res[i][j] = (res[i][j] + A[i][k] * B[k][j]) % MOD;
                }
            }
        }
        return res;
    }
    private long [][] matrixPower(long [][] matrix, int power){
        long [][] res = new long [26][26];
        for(int i = 0; i < 26; i++){
            res[i][i] = 1;
        }
        while(power > 0){
            if((power & 1) == 1){
                res = matrixMultiply(res, matrix);
            }
            matrix = matrixMultiply(matrix, matrix);
            power >>= 1;
        }
        return res;
    }
}