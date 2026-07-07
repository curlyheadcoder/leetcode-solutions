class Solution {
    public long sumAndMultiply(int n) {
        
        long sum = 0;
        long x = 0;
        String s = String.valueOf(n);
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            int d = ch - '0';
            sum += d;
            if(d > 0){
                x = x * 10 + d;
            }
        }
        return x * sum;
    }
}