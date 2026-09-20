class Solution {
    public void gameOfLife(int[][] board) {
        // Neighbors arrays to find 8 neigboring cells for a given cell
        int [] neighbors = {0,1,-1};
        int rows = board.length;
        int cols = board[0].length;
        // Iterate through board cell by cell
        for(int row = 0; row < rows; row++){
            for(int col = 0; col < cols; col++){
                int liveNeighbors = 0;
                for(int i = 0; i < 3; i++){
                    for(int j = 0; j < 3; j++){
                        if(!(neighbors[i] == 0 && neighbors[j] == 0)){
                            int r = (row + neighbors[i]);
                            int c = (col + neighbors[j]);
                            // check the validity of the neighbor cell
                            // and whether it was originally a live cell
                            if((r < rows && r >= 0) && (c < cols && c >= 0) && Math.abs(board[r][c]) == 1){
                                liveNeighbors += 1;
                            }
                        }
                    }
                }
                // Rule 1 or 3
                if((board[row][col] == 1) && (liveNeighbors < 2 || liveNeighbors > 3)){
                    // -1 signifies the cell is now dead but originally was alive
                    board[row][col] = -1;
                }
                // Rule 4
                if(board[row][col] == 0 && liveNeighbors == 3){
                    // 2 signifies the cell now live but originally was dead
                    board[row][col] = 2;
                }
            }
        }
        // get the final representation for the newly updated board
        for(int row = 0; row < rows; row++){
            for(int col = 0; col < cols; col++){
                if(board[row][col] > 0){
                    board[row][col] = 1;
                }else{
                    board[row][col] = 0;
                }
            }
        }
    }
}