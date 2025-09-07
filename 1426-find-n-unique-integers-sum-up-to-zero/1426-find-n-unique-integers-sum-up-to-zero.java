class Solution {
    public int[] sumZero(int n) {
        int [] res = new int [n];
        int start = 1;
        int i = 0;
        while(i+1 < n){
            res[i] = start;
            res[i+1] = -start;
            i += 2;
            start++;
        }
        return res;
    }
}