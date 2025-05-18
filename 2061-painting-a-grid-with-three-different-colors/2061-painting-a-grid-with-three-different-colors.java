class Solution {
    static final int MOD = 1_000_000_007;
    int m, n;
    List<int[]> validPatterns;
    Map<String, Integer> memo;
    Map<String, List<String>> transitions;

    public int colorTheGrid(int m, int n) {
        this.m = m;
        this.n = n;
        validPatterns = new ArrayList<>();
        memo = new HashMap<>();
        transitions = new HashMap<>();

        generateValidPatterns(0, new int[m]);
        buildTransitions();

        int res = 0;
        for (int[] pattern : validPatterns) {
            String key = Arrays.toString(pattern);
            res = (res + dfs(n - 1, key)) % MOD;
        }
        return res;
    }

    private void generateValidPatterns(int row, int[] curr) {
        if (row == m) {
            validPatterns.add(curr.clone());
            return;
        }
        for (int color = 0; color < 3; color++) {
            if (row == 0 || curr[row - 1] != color) {
                curr[row] = color;
                generateValidPatterns(row + 1, curr);
            }
        }
    }

    private void buildTransitions() {
        for (int[] p1 : validPatterns) {
            String key1 = Arrays.toString(p1);
            transitions.putIfAbsent(key1, new ArrayList<>());
            for (int[] p2 : validPatterns) {
                boolean valid = true;
                for (int i = 0; i < m; i++) {
                    if (p1[i] == p2[i]) {
                        valid = false;
                        break;
                    }
                }
                if (valid) {
                    transitions.get(key1).add(Arrays.toString(p2));
                }
            }
        }
    }

    private int dfs(int col, String prevKey) {
        if (col == 0) return 1;
        String state = col + "," + prevKey;
        if (memo.containsKey(state)) return memo.get(state);

        int ways = 0;
        for (String nextKey : transitions.get(prevKey)) {
            ways = (ways + dfs(col - 1, nextKey)) % MOD;
        }
        memo.put(state, ways);
        return ways;
    }
}