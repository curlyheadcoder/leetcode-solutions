class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;
        // Step 1: distance arrays from node1 and node2
        int [] dist1 = new int [n];
        int [] dist2 = new int [n];
        Arrays.fill(dist1, -1);
        Arrays.fill(dist2, -1);
        // Fill distance arrays using DFS  (bfs will work too)
        dfs(edges, node1, dist1);
        dfs(edges, node2, dist2);
        // Step 2: Compare distance
        int minDist = Integer.MAX_VALUE;
        int res = -1;
        for(int i = 0; i < n; i++){
            if(dist1[i] != -1 && dist2[i] != -1){
                int maxDist = Math.max(dist1[i], dist2[i]);
                if(maxDist < minDist){
                    minDist = maxDist;
                    res = i;
                }
            }
        }
        return res;
    }
    private void dfs(int [] edges, int start, int [] dist){
        boolean [] visited = new boolean[edges.length];
        int d = 0;
        while(start != -1 && !visited[start]){
            dist[start] = d;
            visited[start] = true;
            start = edges[start];
            d++;
        }
    }
}