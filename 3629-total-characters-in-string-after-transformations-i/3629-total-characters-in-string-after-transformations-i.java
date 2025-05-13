class Solution {
    final int M = 1_000_000_007;
    public int lengthAfterTransformations(String s, int t) {
        int [] freq = new int [26];
        // Initialize frequency from the string 
        for(char ch : s.toCharArray()){
            freq[ch - 'a']++;
        }
        for(int count = 1; count <= t; count++){
            int [] temp = new int [26];
            for(int i = 0; i < 26; i++){
                if(freq[i] == 0) continue;
                if(i != 25){    // not 'z'
                    temp[i+1] = (temp[i+1] + freq[i]) % M;
                }else{
                    temp[0] = (temp[0] + freq[i]) % M;   // 'z' to 'a'
                    temp[1] = (temp[1] + freq[i]) % M;  //  'z' to 'b' 
                }
            }
            freq = temp;
        }
        int res = 0;
        for(int val : freq){
            res = (res + val) % M;
        }
        return res;
    }
}