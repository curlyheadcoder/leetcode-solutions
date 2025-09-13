class Solution {
    public int maxFreqSum(String s) {
        int [] hash = new int [26];
        for(char ch : s.toCharArray()){
            hash[ch - 'a']++;
        }
        Set<Integer> set = new HashSet<>();
        set.add('a' - 97);
        set.add('e' - 97);
        set.add('i' - 97);
        set.add('o' - 97);
        set.add('u' - 97);

        int maxV = 0;
        int maxC = 0;
        for(int i = 0; i < 26; i++){
            if(set.contains(i)){        // vowel
                maxV = Math.max(maxV, hash[i]);
            }else{
                maxC = Math.max(maxC, hash[i]);
            }

        }
        return maxV + maxC;
    }
}