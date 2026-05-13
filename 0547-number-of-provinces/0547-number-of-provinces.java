class Solution {
    public int findCircleNum(int[][] graph) {
        // visited boolean array
        int n = graph.length;      // no of nodes (vertices)
        boolean [] visited = new boolean[n];
        int provinces = 0;

        // since given graph is undirected and acyclic so we will use DFS/BFS
        // it means it is not connected

        for(int city = 0; city < n; city++){
            if(!visited[city]){
                dfs(graph, visited, city);
                provinces++;
            }
        }

        return provinces;
    }

    private void dfs(int [][] graph, boolean [] visited, int city){
        visited[city] = true;
        for(int nn = 0; nn < graph.length; nn++){       // nn  ---> neighbor city
            if(graph[city][nn] == 1 && !visited[nn]){
                dfs(graph, visited, nn);
            }
        }
    }
}