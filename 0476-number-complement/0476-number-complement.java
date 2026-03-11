class Solution {
    public int findComplement(int num) {
        if(num == 0) return 1;
        int res = 0;
        int counter = 0;
        while(num > 0){
            int r = num%2;
            if(r == 0){
                res += (int) Math.pow(2, counter); 
            }
            counter++;
            num /= 2;
        }
        return res;
    }
}