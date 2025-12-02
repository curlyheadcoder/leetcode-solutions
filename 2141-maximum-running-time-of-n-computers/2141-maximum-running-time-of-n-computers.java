class Solution {
    public long maxRunTime(int n, int[] batteries) {
        long sum = 0;
        for (int b : batteries) sum += b;
        long left = 0, right = sum / n;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            if (canRun(mid, n, batteries)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }
    private boolean canRun(long T, int n, int[] batteries) {
        long total = 0;
        for (long b : batteries) {
            total += Math.min(b, T);
        }
        return total >= (long) n * T;
    }
}