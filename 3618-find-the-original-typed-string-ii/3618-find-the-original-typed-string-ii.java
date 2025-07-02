class Solution {
    private static final int MOD = 1_000_000_007;

    public int possibleStringCount(String word, int k) {
        // Step 1: Compress the word into groups of repeated characters 
        // TODO: Convert "aabbccdd"  => freq = [2,2,2,2]

        int n = word.length();
        List<Integer> freq = new ArrayList<>();
        int count = 1;
        for(int i = 1; i < n; i++){
            if(word.charAt(i) == word.charAt(i-1)) count++;
            else{ 
                freq.add(count);
                count = 1;
            } 
        }
        freq.add(count);      // Add the last group   
        // Step 2: Compute the total possible strings (all combinations)
        // TODO: Multiply choices from each group (1 to group size)
        long totalWays = 1;
        for(int f : freq){
            totalWays = (totalWays * f) % MOD;
        }    
        // Step 3: Optimization - if total groups >= k, then return totalWays 
        if(freq.size() >= k){
            return (int) totalWays;
        }
        // Step 4: Initialize DP arrays for counting invalid strings (length < k)
        // f[j]: number of ways to build string of length j
        // g[j]: prefix sum of f[0] to f[j]
        int [] f = new int [k];
        int [] g = new int [k];
        f[0] = 1;
        Arrays.fill(g,1);   // g[i] = f[0] + ....... + f[i]

        // Step 5: Process each character group using DP + prefix sum trick 
        for(int i = 0; i < freq.size(); i++){
            int groupSize = freq.get(i);
            int [] fNew = new int [k];

            // TODO: Update fNew[j] = sum of f[j - groupSize to j - 1]
            for(int j = 1; j < k; j++){
                fNew[j] = g[j - 1];
                if(j - groupSize - 1 >= 0){
                    fNew[j] = (fNew[j] - g[j - groupSize - 1] + MOD) % MOD;
                }
            }
            // TODO: Build new prefix sum array gNew from fNew
            int [] gNew = new int [k];
            gNew[0] = fNew[0];
            for(int j = 1; j < k; j++){
                gNew[j] = (gNew[j - 1] + fNew[j]) % MOD;
            }
            // Update f and g for next group
            f = fNew;
            g = gNew;
        }
        // Step 6: Subtract all short strings (length < k) from total
        return (int) ((totalWays - g[k - 1] + MOD) % MOD);
    }

}