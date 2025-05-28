class Solution {
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
        int n = edges1.length + 1;
        int m = edges2.length + 1;

        List<Integer>[] graph1 = buildGraph(edges1, n);
        List<Integer>[] graph2 = buildGraph(edges2, m);

        int maxReachableInGraph2 = 0;
        if (k > 0) {
            for (int i = 0; i < m; i++) {
                maxReachableInGraph2 = Math.max(maxReachableInGraph2, dfs(graph2, i, -1, k - 1));
            }
        }

        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = dfs(graph1, i, -1, k) + maxReachableInGraph2;
        }

        return result;
    }

    private List<Integer>[] buildGraph(int[][] edges, int size) {
        List<Integer>[] graph = new List[size];
        for (int i = 0; i < size; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            int a = edge[0], b = edge[1];
            graph[a].add(b);
            graph[b].add(a);
        }
        return graph;
    }

    private int dfs(List<Integer>[] graph, int node, int parent, int depth) {
        if (depth < 0) return 0;
        int count = 1;
        for (int neighbor : graph[node]) {
            if (neighbor != parent) {
                count += dfs(graph, neighbor, node, depth - 1);
            }
        }
        return count;
    }
}