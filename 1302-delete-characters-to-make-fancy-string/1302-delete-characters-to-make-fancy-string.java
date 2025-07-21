class Solution {
    public String makeFancyString(String s) {
        StringBuilder res = new StringBuilder();
        int count = 1;

        for(int i = 0; i < s.length(); i++){
            if(i > 0 && s.charAt(i) == s.charAt(i-1)) count++;
            else count = 1;

            // Only append if less than 3 consecutive characters
            if(count < 3) res.append(s.charAt(i));
        }
        return res.toString();
    }
}