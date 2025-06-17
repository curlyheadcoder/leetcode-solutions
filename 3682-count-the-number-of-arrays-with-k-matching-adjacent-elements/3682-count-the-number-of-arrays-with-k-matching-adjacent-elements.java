class Solution {
    static final int MOD = 1000000007;
    int [] fact;
    int [] invFact;
    public int countGoodArrays(int n, int m, int k) {
        int adjPairPossible = n - 1;
        // Precompute factorials upto n
        preComputeFactorials(adjPairPossible);
        // C(n-1,k)*m
        int combination = (int)((1L * m * nCk(adjPairPossible, k)) % MOD);
        // (m-1)^(n-1-k)
        int secCombination = binaryExpo(m-1, adjPairPossible - k);
        return (int)((1L * combination * secCombination) % MOD);
    }
    void preComputeFactorials(int n){
        fact = new int [n+1];
        invFact = new int [n+1];
        fact[0] = 1;
        for(int i = 1; i <= n; i++){
            fact[i] = (int)((1L * fact[i-1] * i) % MOD);
        }
        invFact[n] = binaryExpo(fact[n], MOD-2);
        for(int i = n - 1; i >= 0; i--){
            invFact[i] = (int)((1L * invFact[i+1] * (i+1)) % MOD);
        }
    }
    int nCk(int n, int k){
        if(k < 0 || k > n) return 0;
        return (int)((1L * fact[n] * invFact[k] % MOD) * invFact[n-k] % MOD);
        }
    int binaryExpo(int base, int exp){
        int res = 1;
        long b = base;
        while(exp > 0){
            if((exp & 1) == 1){
                res = (int)((1L * res * b) % MOD);
            }
            b = (b * b) % MOD;
            exp >>= 1;
        }
        return res;
    }
}