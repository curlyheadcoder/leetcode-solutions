class Solution {
    public boolean checkStrings(String s1, String s2) {
        return check(s1,s2,0) && check(s1,s2,1);
    }
    private boolean check(String s1, String s2, int start){
        int [] freq = new int [26];
        for(int i = start; i < s1.length(); i+=2){
            freq[s1.charAt(i) -'a']++;
            freq[s2.charAt(i) -'a']--;
        }
        for(int count : freq){
            if(count != 0) return false;
        }
        return true;
    }
}