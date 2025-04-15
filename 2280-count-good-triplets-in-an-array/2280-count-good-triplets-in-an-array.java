public class Solution {

    public long goodTriplets(int[] nums1, int[] nums2) {
        int n = nums1.length;

        // Step 1: Map values in nums2 to their indices
        int[] indexInNums2 = new int[n];
        for (int i = 0; i < n; i++) {
            indexInNums2[nums2[i]] = i;
        }

        // Step 2: Transform nums1 into positions in nums2
        int[] transformed = new int[n];
        for (int i = 0; i < n; i++) {
            transformed[i] = indexInNums2[nums1[i]];
        }

        // Step 3: Use Segment Trees
        SegmentTree leftTree = new SegmentTree(n);
        long[] leftCount = new long[n];

        for (int i = 0; i < n; i++) {
            leftCount[i] = leftTree.query(0, transformed[i] - 1);
            leftTree.update(transformed[i], 1);
        }

        SegmentTree rightTree = new SegmentTree(n);
        long[] rightCount = new long[n];

        for (int i = n - 1; i >= 0; i--) {
            rightCount[i] = rightTree.query(transformed[i] + 1, n - 1);
            rightTree.update(transformed[i], 1);
        }

        // Step 4: Calculate result
        long total = 0;
        for (int i = 0; i < n; i++) {
            total += leftCount[i] * rightCount[i];
        }

        return total;
    }

    // Segment Tree for range sum queries
    static class SegmentTree {
        int[] tree;
        int size;

        public SegmentTree(int n) {
            size = n;
            tree = new int[4 * n];
        }

        public void update(int index, int value) {
            update(0, 0, size - 1, index, value);
        }

        private void update(int node, int start, int end, int idx, int value) {
            if (start == end) {
                tree[node] += value;
                return;
            }
            int mid = (start + end) / 2;
            if (idx <= mid) {
                update(2 * node + 1, start, mid, idx, value);
            } else {
                update(2 * node + 2, mid + 1, end, idx, value);
            }
            tree[node] = tree[2 * node + 1] + tree[2 * node + 2];
        }

        public int query(int l, int r) {
            return query(0, 0, size - 1, l, r);
        }

        private int query(int node, int start, int end, int l, int r) {
            if (r < start || end < l) return 0;
            if (l <= start && end <= r) return tree[node];
            int mid = (start + end) / 2;
            int left = query(2 * node + 1, start, mid, l, r);
            int right = query(2 * node + 2, mid + 1, end, l, r);
            return left + right;
        }
    }
}
