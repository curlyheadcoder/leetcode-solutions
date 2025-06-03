class Solution {
    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        int n = status.length;
        boolean[] hasKey = new boolean[n];
        boolean[] used = new boolean[n];
        boolean[] hasBox = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();

        // Mark initial boxes as available
        for (int box : initialBoxes) {
            hasBox[box] = true;
        }

        // Enqueue all initially open boxes
        for (int box : initialBoxes) {
            if (status[box] == 1) {
                queue.offer(box);
                used[box] = true;
            }
        }

        int totalCandies = 0;

        while (!queue.isEmpty()) {
            int box = queue.poll();
            totalCandies += candies[box];

            // Collect keys from the current box
            for (int key : keys[box]) {
                hasKey[key] = true;
                if (hasBox[key] && !used[key]) {
                    queue.offer(key);
                    used[key] = true;
                }
            }

            // Collect contained boxes
            for (int contained : containedBoxes[box]) {
                hasBox[contained] = true;
                if ((status[contained] == 1 || hasKey[contained]) && !used[contained]) {
                    queue.offer(contained);
                    used[contained] = true;
                }
            }

            // Try opening other boxes that are now possible due to new keys
            for (int i = 0; i < n; i++) {
                if (hasBox[i] && hasKey[i] && !used[i] && status[i] == 0) {
                    queue.offer(i);
                    used[i] = true;
                }
            }
        }

        return totalCandies;
    }
}