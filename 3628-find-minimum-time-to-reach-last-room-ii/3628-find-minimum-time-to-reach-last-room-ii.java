class Solution {
    private static final int[][] DIRECTIONS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int minTimeToReach(int[][] moveTime) {
        int n = moveTime.length;
        int m = moveTime[0].length;

        int[][][] dist = new int[n][m][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Arrays.fill(dist[i][j], Integer.MAX_VALUE);
            }
        }
        dist[0][0][0] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{0, 0, 0, 0}); // {time, x, y, moveNumber}

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int time = current[0];
            int x = current[1];
            int y = current[2];
            int moveNumber = current[3];

            if (x == n - 1 && y == m - 1) {
                return time;
            }

            if (time > dist[x][y][moveNumber % 2]) {
                continue;
            }

            for (int[] dir : DIRECTIONS) {
                int nx = x + dir[0];
                int ny = y + dir[1];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    continue;
                }

                int nextMoveNumber = moveNumber + 1;
                int moveCost = (moveNumber % 2 == 0) ? 1 : 2;
                int reachTime = Math.max(moveTime[nx][ny], time) + moveCost;

                if (reachTime < dist[nx][ny][nextMoveNumber % 2]) {
                    dist[nx][ny][nextMoveNumber % 2] = reachTime;
                    pq.offer(new int[]{reachTime, nx, ny, nextMoveNumber});
                }
            }
        }

        return -1;
    }
}
