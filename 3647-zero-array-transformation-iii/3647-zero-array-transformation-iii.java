class Solution {
    public int maxRemoval(int[] nums, int[][] queries) {
        int n = nums.length;
        int m = queries.length;

        // Sort queries based on start index
        Arrays.sort(queries, Comparator.comparingInt(a -> a[0]));

        // Max-heap for available queries (stores end indices)
        PriorityQueue<Integer> available = new PriorityQueue<>(Collections.reverseOrder());
        // Min-heap for used queries (stores end indices)
        PriorityQueue<Integer> used = new PriorityQueue<>();

        int queryIndex = 0;
        int appliedCount = 0;

        for (int i = 0; i < n; i++) {
            // Add all queries starting at index i to the available heap
            while (queryIndex < m && queries[queryIndex][0] == i) {
                available.offer(queries[queryIndex][1]);
                queryIndex++;
            }

            // Remove expired queries from the used heap
            while (!used.isEmpty() && used.peek() < i) {
                used.poll();
            }

            // Apply queries to reduce nums[i] to 0
            while (nums[i] > used.size()) {
                // Remove expired queries from the available heap
                while (!available.isEmpty() && available.peek() < i) {
                    available.poll();
                }

                if (available.isEmpty()) {
                    return -1;
                }

                // Apply the query with the farthest end index
                int end = available.poll();
                used.offer(end);
                appliedCount++;
            }
        }

        return m - appliedCount;
    }
}