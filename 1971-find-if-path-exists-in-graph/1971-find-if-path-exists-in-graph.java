class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        // Create Adjacent list (graph)
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }
        // Build graph
        for(int [] edge : edges){
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        // bfs approach 
        Queue<Integer> q = new LinkedList<>();
        boolean [] visited = new boolean[n];
        q.offer(source);
        visited[source] = true;

        while(!q.isEmpty()){
            int currNode = q.poll();
            if(currNode == destination) return true;        // valid path exist (dest found)
            // otherwise
            for(int nn : graph.get(currNode)){
                if(!visited[nn]){
                    visited[nn] = true;
                    q.offer(nn);
                }
            }
        }
        return false;
    }
}