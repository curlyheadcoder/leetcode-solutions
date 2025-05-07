class Solution {
    private static final int[][] DIRECTIONS = {{1,0}, {-1,0}, {0,1}, {0,-1}};

    public int minTimeToReach(int[][] moveTime) {
        int n = moveTime.length;
        int m = moveTime[0].length;

        int[][] dist = new int[n][m];
        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        dist[0][0] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{0, 0, 0}); // {time, x, y}

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int time = current[0];
            int x = current[1];
            int y = current[2];

            if (x == n - 1 && y == m - 1) {
                return time;
            }

            if (time > dist[x][y]) {
                continue;
            }

            for (int[] dir : DIRECTIONS) {
                int nx = x + dir[0];
                int ny = y + dir[1];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    continue;
                }

                int waitTime = Math.max(moveTime[nx][ny], time) + 1;
                if (waitTime < dist[nx][ny]) {
                    dist[nx][ny] = waitTime;
                    pq.offer(new int[]{waitTime, nx, ny});
                }
            }
        }

        return -1;
    }
}
