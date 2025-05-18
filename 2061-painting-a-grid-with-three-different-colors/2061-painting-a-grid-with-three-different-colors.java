class Solution {
    static final int MOD = 1_000_000_007;

    public int colorTheGrid(int m, int n) {
        List<String> patterns = new ArrayList<>();
        Map<String, List<String>> nextMap = new HashMap<>();

        generatePatterns(m, "", patterns);

        for (String p1 : patterns) {
            for (String p2 : patterns) {
                if (isCompatible(p1, p2, m)) {
                    nextMap.computeIfAbsent(p1, k -> new ArrayList<>()).add(p2);
                }
            }
        }

        Map<String, Integer> dp = new HashMap<>();
        for (String p : patterns) dp.put(p, 1);

        for (int i = 1; i < n; i++) {
            Map<String, Integer> newDp = new HashMap<>();
            for (String prev : dp.keySet()) {
                int count = dp.get(prev);
                for (String next : nextMap.get(prev)) {
                    newDp.put(next, (newDp.getOrDefault(next, 0) + count) % MOD);
                }
            }
            dp = newDp;
        }

        int res = 0;
        for (int val : dp.values()) res = (res + val) % MOD;
        return res;
    }

    private void generatePatterns(int m, String curr, List<String> patterns) {
        if (curr.length() == m) {
            patterns.add(curr);
            return;
        }
        for (char c = '0'; c <= '2'; c++) {
            if (curr.isEmpty() || curr.charAt(curr.length() - 1) != c) {
                generatePatterns(m, curr + c, patterns);
            }
        }
    }

    private boolean isCompatible(String p1, String p2, int m) {
        for (int i = 0; i < m; i++) {
            if (p1.charAt(i) == p2.charAt(i)) return false;
        }
        return true;
    }
}