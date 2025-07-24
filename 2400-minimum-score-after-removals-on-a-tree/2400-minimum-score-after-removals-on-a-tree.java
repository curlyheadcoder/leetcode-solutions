class Solution {
    private List<Integer>[] tree;
    private int[] subtreeXor;
    private int[] tin, tout;
    private int timer = 0;
    private int totalXor;

    public int minimumScore(int[] nums, int[][] edges) {
        int n = nums.length;

        // Step 1: Build adjacency list
        tree = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            tree[edge[0]].add(edge[1]);
            tree[edge[1]].add(edge[0]);
        }

        subtreeXor = new int[n];
        tin = new int[n];
        tout = new int[n];

        // Step 2: DFS to compute subtree XOR and entry/exit time for ancestor check
        dfs(0, -1, nums);

        totalXor = subtreeXor[0];
        int minScore = Integer.MAX_VALUE;

        // Step 3: Try all unordered pairs of edges (represented by their child node)
        for (int i = 1; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isAncestor(i, j)) {
                    int x = subtreeXor[j];
                    int y = subtreeXor[i] ^ subtreeXor[j];
                    int z = totalXor ^ subtreeXor[i];
                    minScore = Math.min(minScore, getScore(x, y, z));
                } else if (isAncestor(j, i)) {
                    int x = subtreeXor[i];
                    int y = subtreeXor[j] ^ subtreeXor[i];
                    int z = totalXor ^ subtreeXor[j];
                    minScore = Math.min(minScore, getScore(x, y, z));
                } else {
                    int x = subtreeXor[i];
                    int y = subtreeXor[j];
                    int z = totalXor ^ x ^ y;
                    minScore = Math.min(minScore, getScore(x, y, z));
                }
            }
        }
        return minScore;
    }

    private void dfs(int node, int parent, int[] nums) {
        tin[node] = ++timer;
        subtreeXor[node] = nums[node];  // Assign the current node's value (was incorrectly tree[node])
        for (int neighbor : tree[node]) {
            if (neighbor != parent) {
                dfs(neighbor, node, nums);
                subtreeXor[node] ^= subtreeXor[neighbor];
            }
        }
        tout[node] = ++timer; // Assign to tout, not tree[node]
    }

    // Fast ancestor check using Euler Tour time-in/out
    private boolean isAncestor(int u, int v) {
        return tin[u] <= tin[v] && tout[v] <= tout[u];
    }

    private int getScore(int a, int b, int c) {
        int max = Math.max(a, Math.max(b, c));
        int min = Math.min(a, Math.min(b, c));
        return max - min;
    }
}