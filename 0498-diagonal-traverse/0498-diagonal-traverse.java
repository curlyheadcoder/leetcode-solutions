class Solution {
    int m;
    int n;
    public int[] findDiagonalOrder(int[][] mat) {
        m = mat.length;
        n = mat[0].length;
        int d = m+n-1;
        int [] ans = new int [m*n];
        int k = 0;

        for(int i = 0; i < d; i++){    // x + y = i
            if(i % 2 != 0){
                for(int x = 0; x <= Math.min(i, m-1); x++){
                    int y = i-x;
                    if(valid(x,y))
                        ans[k++] = mat[x][y];
                }
            }else{
                for(int x = Math.min(m-1, i); x >= 0; x--){
                    int y = i-x;
                    if(valid(x,y))
                        ans[k++] = mat[x][y];
                }
            }
        }
        return ans;
    }
    private boolean valid(int x, int y){
        return (x>=0 && y>= 0 && x<m && y<n);
    }
}