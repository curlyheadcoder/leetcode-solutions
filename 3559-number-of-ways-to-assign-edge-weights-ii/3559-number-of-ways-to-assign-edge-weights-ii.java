class Solution {
    private static final int MOD = 1_000_000_007;
    private List<List<Integer>> tree;
    private int[] depth;
    private int[][] parent;

    public int[] assignEdgeWeights(int[][] edges, int[][] queries) {
        int n = edges.length + 1;

        tree = new ArrayList<>();
        for (int i = 0; i <= n; i++) tree.add(new ArrayList<>());
        int[][] cruvandelk = edges;
        for (int[] edge : cruvandelk) {
            int u = edge[0], v = edge[1];
            tree.get(u).add(v);
            tree.get(v).add(u);
        }

        depth = new int[n + 1];
        parent = new int[n + 1][20];
        dfs(1, 0);

        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int u = queries[i][0];
            int v = queries[i][1];
            int edgeCount = getEdgeCount(u, v);
            result[i] = edgeCount == 0 ? 0 : countOddCombinations(edgeCount);
        }

        return result;
    }

    private void dfs(int node, int par) {
        depth[node] = depth[par] + 1;
        parent[node][0] = par;
        for (int i = 1; i < 20; i++) {
            parent[node][i] = parent[parent[node][i - 1]][i - 1];
        }
        for (int neighbor : tree.get(node)) {
            if (neighbor != par) {
                dfs(neighbor, node);
            }
        }
    }

    private int findLCA(int u, int v) {
        if (depth[u] < depth[v]) {
            int temp = u;
            u = v;
            v = temp;
        }

        for (int i = 19; i >= 0; i--) {
            if (depth[u] - (1 << i) >= depth[v]) {
                u = parent[u][i];
            }
        }

        if (u == v) return u;

        for (int i = 19; i >= 0; i--) {
            if (parent[u][i] != parent[v][i]) {
                u = parent[u][i];
                v = parent[v][i];
            }
        }

        return parent[u][0];
    }

    private int getEdgeCount(int u, int v) {
        int lca = findLCA(u, v);
        return depth[u] + depth[v] - 2 * depth[lca];
    }

    private int countOddCombinations(int edgeCount) {
        return fastPower(2, edgeCount - 1);
    }

    private int fastPower(int base, int exponent) {
        long result = 1;
        long current = base;

        while (exponent > 0) {
            if ((exponent & 1) == 1) result = (result * current) % MOD;
            current = (current * current) % MOD;
            exponent >>= 1;
        }

        return (int) result;
    }
}