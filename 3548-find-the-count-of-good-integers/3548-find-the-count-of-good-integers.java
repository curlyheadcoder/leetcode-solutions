class Solution {
    public long countGoodIntegers(int n, int k) {
        long[] factorial = new long[n+1];
        factorial[0] = 1;
        for(int i = 1; i <= n; i++){
            factorial[i] = factorial[i-1]*i;
        }
        long res = 0;
        Set<String> seen = new HashSet<>();
        int halfLen = (n+1)/2;
        int start = (int) Math.pow(10, halfLen-1);
        int end = (int) Math.pow(10, halfLen);

        for(int i = start; i < end; i++){
            String firstHalf = String.valueOf(i);
            String secondHalf = new StringBuilder(firstHalf).reverse().toString();
            String palindrome = firstHalf + secondHalf.substring(n%2);
            if(Long.parseLong(palindrome) % k != 0) continue;
            char [] chars = palindrome.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);
            if(seen.contains(sorted)) continue;
            seen.add(sorted);
            int [] count = new int[10];
            for(char c : chars){
                count[c-'0']++;
            }
            long permutations = (n - count[0]) * factorial[n-1];
            for(int c : count){
                if(c > 1){
                    permutations /= factorial[c];
                }
            } 
            res += permutations;
        }
        return res;
    }
}