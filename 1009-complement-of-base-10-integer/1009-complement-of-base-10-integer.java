class Solution {
    public int bitwiseComplement(int n) {
        if(n == 0) return 1;
        int res = 0;
        int counter = 0;
        while(n > 0){
            int r = n % 2;
            if(r == 0){
                res += (int) Math.pow(2, counter);
            }
            counter++;
            n /= 2;
        }
        return res;
    }
}