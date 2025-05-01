import java.util.*;

class Solution {

    private boolean isPossible(int mid, int[] tasks, TreeMap<Integer, Integer> map, int pills, int strength) {
        TreeMap<Integer, Integer> clone = new TreeMap<>(map);
        for (int i = mid - 1; i >= 0; i--) {
            int t = tasks[i];
            Integer hi = clone.lastKey();
            if (hi >= t) {
                if (clone.get(hi) == 1) clone.remove(hi);
                else clone.put(hi, clone.get(hi) - 1);
            } else {
                if (pills == 0) return false;
                Integer lo = clone.ceilingKey(t - strength);
                if (lo == null) return false;
                if (clone.get(lo) == 1) clone.remove(lo);
                else clone.put(lo, clone.get(lo) - 1);
                pills--;
            }
        }
        return true;
    }

    public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
        Arrays.sort(tasks);
        Arrays.sort(workers);

        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int w : workers) {
            map.put(w, map.getOrDefault(w, 0) + 1);
        }

        int n = tasks.length, m = workers.length;
        int start = 0, end = Math.min(n, m);
        int ans = 0;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (isPossible(mid, tasks, map, pills, strength)) {
                ans = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return ans;
    }
}
