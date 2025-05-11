class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int [] freq = new int [26];
        // Step 1: Count characters in magazine 
        for(char ch : magazine.toCharArray()){
            freq[ch - 'a']++;
        }
        // Step 2: Check each char in ransomNote 
        for(char ch : ransomNote.toCharArray()){
            if(freq[ch - 'a'] == 0){
                return false;     // not enough letters 
            }
            freq[ch - 'a']--;
        }
        return true;
    }
}