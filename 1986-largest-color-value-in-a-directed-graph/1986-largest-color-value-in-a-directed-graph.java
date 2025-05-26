class Solution {
    public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();
        List<List<Integer>> graph = new ArrayList<>();
        int [] indegree = new int [n];
        // Build graph and compute indegrees
        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }
        for(int [] edge : edges){
            graph.get(edge[0]).add(edge[1]);
            indegree[edge[1]]++;
        }

        // Queue for topological sort
        Queue<Integer> queue = new LinkedList<>();
        // Initialize color count for each node, 26 colors max
        int [][] colorCount = new int [n][26];
        // Start with nodes having 0 indegree
        for(int i = 0; i < n; i++){
            if(indegree[i] == 0){
                queue.offer(i);
                colorCount[i][colors.charAt(i) - 'a'] = 1;
            }
        }

        int visited = 0;
        int maxColorValue = 0;

        while(!queue.isEmpty()){
            int node = queue.poll();
            visited++;
            int currColorIndex = colors.charAt(node) -'a';
            maxColorValue = Math.max(maxColorValue, colorCount[node][currColorIndex]);
            for(int neighbor : graph.get(node)){
                // Update color frequency counts for neighbor
                for(int c = 0; c < 26; c++){
                    int count = colorCount[node][c]+ (colors.charAt(neighbor) - 'a' == c ? 1 : 0);
                    colorCount[neighbor][c] = Math.max(colorCount[neighbor][c], count);
                }
                indegree[neighbor]--;
                if(indegree[neighbor] == 0){
                    queue.offer(neighbor);
                }
            }
        }
        // if there are unvisited nodes, graph has a cycle
        return visited == n ? maxColorValue : -1;
    }
}