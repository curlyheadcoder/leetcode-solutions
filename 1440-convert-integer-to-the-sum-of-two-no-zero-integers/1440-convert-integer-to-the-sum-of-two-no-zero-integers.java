class Solution {
    public int[] getNoZeroIntegers(int n) {
        for(int i = 1; i < n; i++){
            if(hasZero(i) || hasZero(n-i)){
                continue;
            }
            return new int []{i, n-i};
        }
        return new int []{-1, -1};
    }
    private boolean hasZero(int a){
        while(a > 0){
            if(a % 10 == 0){
                return true;
            }
            a /= 10;
        }
        return false;
    }
}