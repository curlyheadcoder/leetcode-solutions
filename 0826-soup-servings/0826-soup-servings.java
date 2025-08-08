class Solution {
    public double soupServings(int n) {
        int servings = (int)Math.ceil(n / 25.0); // Each operation serves up to 25ml
        Map<Integer, Map<Integer, Double>> memo = new HashMap<>();
        memo.put(0, new HashMap<>());
        memo.get(0).put(0, 0.5);

        for (int portion = 1; portion <= servings; portion++) {
            memo.put(portion, new HashMap<>());
            memo.get(0).put(portion, 1.0);
            memo.get(portion).put(0, 0.0);

            for (int left = 1; left <= portion; left++) {
                memo.get(left).put(portion, calculateProb(left, portion, memo));
                memo.get(portion).put(left, calculateProb(portion, left, memo));
            }
            if (memo.get(portion).get(portion) > 1 - 1e-5) {
                return 1.0; // Early return for large n
            }
        }

        return memo.get(servings).get(servings);
    }

    private double calculateProb(int a, int b, Map<Integer, Map<Integer, Double>> memo) {
        double prob = 0.0;
        prob += memo.get(Math.max(0, a - 4)).get(b);
        prob += memo.get(Math.max(0, a - 3)).get(b - 1);
        prob += memo.get(Math.max(0, a - 2)).get(Math.max(0, b - 2));
        prob += memo.get(a - 1).get(Math.max(0, b - 3));
        return prob / 4;
    }
}