class Solution {
    public int countTriples(int n) {
        int count = 0;
        for(int a = 1; a <= n; a++){
            for(int b = a+1; b <= n; b++){
                double sum = Math.sqrt(a*a + b*b);
                if(sum == Math.floor(sum) && sum <= n){
                    count += 2;
                }
            }
        }
        return count;
    }
}