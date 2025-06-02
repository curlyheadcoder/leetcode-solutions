class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean [][] visited = new boolean[m][n];
        List<Integer> res = new ArrayList<>();
        // Direction vectors : right, down, left, up
        int [] dr = {0,1,0,-1};
        int [] dc = {1,0,-1,0};
        int dir = 0;     // Start with right direction
        int r = 0, c = 0;
        for(int i = 0; i < m*n; i++){
            res.add(matrix[r][c]);
            visited[r][c] = true;
            int nr = r + dr[dir];
            int nc = c + dc[dir];

            // Check if next move is within bounds and not visited
            if(nr >= 0 && nr < m && nc >= 0 && nc < n && !visited[nr][nc]){
                r = nr;
                c = nc;
            }else{
                // change direction
                dir = (dir+1)%4;
                r += dr[dir];
                c += dc[dir];
            }
        }
        return res;
    }
}