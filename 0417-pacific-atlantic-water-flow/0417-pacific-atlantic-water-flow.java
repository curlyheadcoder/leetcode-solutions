class Solution {
    private int rows, cols;
    private int[][] heights;
    private boolean[][] pacificVisited;
    private boolean[][] atlanticVisited;
    private final int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        if (heights == null || heights.length == 0) return result;

        this.heights = heights;
        rows = heights.length;
        cols = heights[0].length;
        pacificVisited = new boolean[rows][cols];
        atlanticVisited = new boolean[rows][cols];

        // DFS from Pacific border cells (top row and left column)
        for (int r = 0; r < rows; r++) {
            dfs(r, 0, pacificVisited);
        }
        for (int c = 0; c < cols; c++) {
            dfs(0, c, pacificVisited);
        }

        // DFS from Atlantic border cells (bottom row and right column)
        for (int r = 0; r < rows; r++) {
            dfs(r, cols - 1, atlanticVisited);
        }
        for (int c = 0; c < cols; c++) {
            dfs(rows - 1, c, atlanticVisited);
        }

        // Collect cells reachable by both oceans
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (pacificVisited[r][c] && atlanticVisited[r][c]) {
                    result.add(Arrays.asList(r, c));
                }
            }
        }

        return result;
    }

    private void dfs(int r, int c, boolean[][] visited) {
        visited[r][c] = true;
        for (int[] dir : directions) {
            int nr = r + dir[0];
            int nc = c + dir[1];
            if (nr >= 0 && nr < rows && nc >= 0 && nc < cols &&
                !visited[nr][nc] && heights[nr][nc] >= heights[r][c]) {
                dfs(nr, nc, visited);
            }
        }
    }
}
