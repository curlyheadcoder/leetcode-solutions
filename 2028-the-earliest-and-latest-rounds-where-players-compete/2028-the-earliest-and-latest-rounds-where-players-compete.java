class Solution {

    Map<String, int[]> memo = new HashMap<>();

    public int[] earliestAndLatest(int n, int firstPlayer, int secondPlayer) {
        // Ensure firstPlayer is smaller
        if (firstPlayer > secondPlayer) {
            int temp = firstPlayer;
            firstPlayer = secondPlayer;
            secondPlayer = temp;
        }

        List<Integer> players = new ArrayList<>();
        for (int i = 1; i <= n; i++) players.add(i);

        return dfs(players, firstPlayer, secondPlayer, 1);
    }

    private int[] dfs(List<Integer> players, int first, int second, int round) {
        int n = players.size();

        // Base case: If they meet
        for (int i = 0; i < n / 2; i++) {
            if ((players.get(i) == first && players.get(n - 1 - i) == second) ||
                (players.get(i) == second && players.get(n - 1 - i) == first)) {
                return new int[]{round, round};
            }
        }

        String key = players.toString() + "|" + round;
        if (memo.containsKey(key)) return memo.get(key);

        List<List<Integer>> nextRounds = new ArrayList<>();
        generateNextRounds(players, 0, new ArrayList<>(), nextRounds, first, second);

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (List<Integer> next : nextRounds) {
            Collections.sort(next); // Normalize state
            int[] res = dfs(next, first, second, round + 1);
            min = Math.min(min, res[0]);
            max = Math.max(max, res[1]);
        }

        int[] result = new int[]{min, max};
        memo.put(key, result);
        return result;
    }

    private void generateNextRounds(List<Integer> players, int i, List<Integer> current,
                                    List<List<Integer>> result, int first, int second) {
        int n = players.size();
        if (i >= n / 2) {
            if (n % 2 == 1 && i == n / 2) {
                current.add(players.get(i));
            }
            result.add(new ArrayList<>(current));
            if (n % 2 == 1 && i == n / 2) {
                current.remove(current.size() - 1);
            }
            return;
        }

        int a = players.get(i);
        int b = players.get(n - 1 - i);

        // Handle match between first and second
        if ((a == first && b == second) || (a == second && b == first)) {
            return; // Already handled in base case
        }

        // If one of them is first or second, force them to win
        if (a == first || b == first) {
            current.add(first);
            generateNextRounds(players, i + 1, current, result, first, second);
            current.remove(current.size() - 1);
        } else if (a == second || b == second) {
            current.add(second);
            generateNextRounds(players, i + 1, current, result, first, second);
            current.remove(current.size() - 1);
        } else {
            // Try both players as winners
            current.add(a);
            generateNextRounds(players, i + 1, current, result, first, second);
            current.remove(current.size() - 1);

            current.add(b);
            generateNextRounds(players, i + 1, current, result, first, second);
            current.remove(current.size() - 1);
        }
    }
}
