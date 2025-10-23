class Solution {
    public boolean hasSameDigits(String s) {
        if(s == null) return false;
        if(s.length() == 2) return s.charAt(0) == s.charAt(1);
        while(s.length() > 2){
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i + 1 < s.length(); i++){
                int a = s.charAt(i) - '0';
                int b = s.charAt(i+1) - '0';
                int rem = (a + b) % 10;
                sb.append((char) ('0' + rem));
            }
            s = sb.toString();
        }
        return s.length() == 2 && s.charAt(0) == s.charAt(1);
    }
}