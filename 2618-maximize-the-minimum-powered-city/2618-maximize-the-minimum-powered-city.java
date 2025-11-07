class Solution {
    public long maxPower(int[] stations, int r, long k) {
        int n = stations.length;
        long[] prefix = new long[n];
        prefix[0] = stations[0];
        for (int i = 1; i < n; i++) prefix[i] = prefix[i - 1] + stations[i];

        long[] power = new long[n];
        for (int i = 0; i < n; i++) {
            int left = Math.max(0, i - r);
            int right = Math.min(n - 1, i + r);
            power[i] = prefix[right] - (left > 0 ? prefix[left - 1] : 0L);
        }

        long total = prefix[n - 1] + k;
        long low = 0, high = total, ans = 0;
        while (low <= high) {
            long mid = (low + high) / 2;
            if (isPossible(power, r, k, mid)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    private boolean isPossible(long[] power, int r, long k, long target) {
        int n = power.length;
        long[] diff = new long[n + 1]; 
        long currAd = 0;
        long remain = k;
        for (int i = 0; i < n; i++) {
            currAd += diff[i];
            long curr = power[i] + currAd;
            if (curr < target) {
                long need = target - curr;
                if (need > remain) return false;
                remain -= need;
                currAd += need;
                int pos = Math.min(n - 1, i + r);
                int end = pos + r + 1;
                if (end <= n) {
                    diff[end] -= need;
                }
            }
        }
        return true;
    }
}