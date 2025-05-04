class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        int [][] count = new int [10][10];
        int ans = 0;
        for(int [] d : dominoes){
            int first = d[0];
            int second = d[1];
            if(first > second){
                int temp = first;
                first = second;
                second = temp;
            }
            ans += count[first][second]++;
        }
        return ans;
    }
}