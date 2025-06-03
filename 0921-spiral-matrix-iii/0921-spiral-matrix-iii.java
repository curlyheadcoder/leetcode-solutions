class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int [][] res = new int[rows*cols][2];
        int count = 0;
        int [] dr = {0,1,0,-1};     // East South West North
        int [] dc = {1,0,-1,0};
        int len = 1;     // Step length
        int dir = 0;     // 0: East, 1: South, 2: West, 3: North
        int r = rStart, c = cStart;
        res[count++] = new int []{r,c};
        while(count < rows*cols){
            for(int i = 0; i < 2; i++){
                // 2 times per loop (to increase step after 2 directions)
                for(int j = 0; j < len; j++){
                    r += dr[dir];
                    c += dc[dir];
                    if(r >= 0 && r < rows && c >= 0 && c < cols){
                        res[count++] = new int []{r,c};
                    }
                }
                dir = (dir + 1) % 4;      // rotate direction
            }
            len++;       // increase steps after 2 directions
        }
        return res;
    }
}