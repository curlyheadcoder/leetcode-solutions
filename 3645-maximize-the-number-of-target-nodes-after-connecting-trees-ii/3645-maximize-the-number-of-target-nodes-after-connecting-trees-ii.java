class Solution {
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2) {
        // Step 1: Get the number of nodes in each tree
        int n = edges1.length + 1;
        int m = edges2.length + 1;

        // Step 2: Color arrays to store parity (0 = even depth, 1 = odd depth)
        int[] color1 = new int[n];
        int[] color2 = new int[m];

        // Step 3: Count even and odd depth nodes for both trees
        int[] count1 = buildAndCountParity(edges1, color1);  // count1[0] = even count, count1[1] = odd count 
        int[] count2 = buildAndCountParity(edges2, color2);  // count2[0] = even count, count2[1] = odd count

        // Step 4: Initialize result array
        int[] res = new int[n];

        // Step 5: For each node in Tree1, calculate max possible target nodes
        for (int i = 0; i < n; i++) {
            int parity = color1[i];                             // current node's parity
            int sameTreeCount = count1[parity];                 // nodes of same parity in Tree1
            int otherTreeMax = Math.max(count2[0], count2[1]);  // best we can do from Tree2
            res[i] = sameTreeCount + otherTreeMax;
        }

        return res;
    }

    // TODO: Build tree, assign parity using DFS and count parity
    private int[] buildAndCountParity(int[][] edges, int[] color) {
        int n = edges.length + 1;

        // Step 1: Build adjacency list
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        // Step 2: Run DFS to assign parity and count even nodes
        int evenCount = dfsAssignParity(0, -1, 0, graph, color);  // added depth = 0 as argument
        int oddCount = n - evenCount;

        return new int[]{evenCount, oddCount};
    }

    // TODO: DFS to assign parity color and count even-depth nodes
    private int dfsAssignParity(
        int node,
        int parent,
        int depth,
        List<List<Integer>> graph,
        int[] color
    ) {
        int isEven = 1 - (depth % 2);    // even = 1, odd = 0 (used for counting)
        color[node] = depth % 2;         // store parity at each node
        int evenCount = isEven;

        for (int neighbor : graph.get(node)) {
            if (neighbor != parent) {
                evenCount += dfsAssignParity(neighbor, node, depth + 1, graph, color);
            }
        }
        return evenCount;
    }
}
