class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<double[]> heap = new PriorityQueue<>(
            (a, b) -> Double.compare(b[0], a[0])
        );

        // Initialize the heap with each class and its gain if an extra student is added
        for (int[] cls : classes) {
            int passCount = cls[0];
            int totalCount = cls[1];
            double improvement = gainAfterAdding(passCount, totalCount);
            heap.offer(new double[] {improvement, passCount, totalCount});
        }

        // Add extra students to the class that yields the highest gain
        while (extraStudents > 0) {
            double[] top = heap.poll();
            int passCount = (int) top[1];
            int totalCount = (int) top[2];

            passCount++;
            totalCount++;
            double newGain = gainAfterAdding(passCount, totalCount);
            heap.offer(new double[] {newGain, passCount, totalCount});

            extraStudents--;
        }

        // Compute the final average ratio
        double sumRatios = 0;
        while (!heap.isEmpty()) {
            double[] current = heap.poll();
            int passCount = (int) current[1];
            int totalCount = (int) current[2];
            sumRatios += (double) passCount / totalCount;
        }

        return sumRatios / classes.length;
    }

    private double gainAfterAdding(int passCount, int totalCount) {
        double currentRatio = (double) passCount / totalCount;
        double newRatio = (double) (passCount + 1) / (totalCount + 1);
        return newRatio - currentRatio;
    }
}
