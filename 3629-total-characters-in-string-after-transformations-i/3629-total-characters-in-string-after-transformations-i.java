class Solution {
    static final int MOD = 1000000007;
    public int lengthAfterTransformations(String s, int t) {
        int [] count = new int [26];
        long res = s.length();
        int z = 25;
        for(int i = 0; i <s.length(); i++){
            char ch = s.charAt(i);
            count[ch - 'a']++;
        }
        while(t-- > 0){
            res = (res + count[z]) % MOD;
            count[(z+1) % 26] = (int)((count[(z+1)%26] + (long) count[z]) % MOD);
            z = (z+25) % 26;
        }
        return (int) res;
    }
}