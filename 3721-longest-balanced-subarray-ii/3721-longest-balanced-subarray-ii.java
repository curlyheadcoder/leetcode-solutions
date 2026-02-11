class Solution {
    public int longestBalanced(int[] a) {
        int n = a.length;
        if (n == 0) return 0;

        class Seg {
            int n;
            int[] mn, mx, lz;
            Seg(int N) {
                n = N;
                mn = new int[N << 2];
                mx = new int[N << 2];
                lz = new int[N << 2];
            }
            void ap(int p, int v) { mn[p] += v; mx[p] += v; lz[p] += v; }
            void pd(int p) {
                int t = lz[p];
                if (t == 0) return;
                ap(p << 1, t);
                ap(p << 1 | 1, t);
                lz[p] = 0;
            }
            void upd(int p, int l, int r, int ql, int qr, int v) {
                if (ql > r || qr < l) return;
                if (ql <= l && r <= qr) { ap(p, v); return; }
                pd(p); int m = (l + r) >> 1;
                upd(p << 1, l, m, ql, qr, v);
                upd(p << 1 | 1, m + 1, r, ql, qr, v);
                mn[p] = Math.min(mn[p << 1], mn[p << 1 | 1]);
                mx[p] = Math.max(mx[p << 1], mx[p << 1 | 1]);
            }
            int fz(int p, int l, int r, int ql, int qr) {
                if (ql > r || qr < l) return Integer.MAX_VALUE;
                if (mn[p] > 0 || mx[p] < 0) return Integer.MAX_VALUE;
                if (l == r) return l;
                pd(p); int m = (l + r) >> 1;
                int z = fz(p << 1, l, m, ql, qr);
                if (z != Integer.MAX_VALUE) return z;
                return fz(p << 1 | 1, m + 1, r, ql, qr);
            }
        }

        Seg seg = new Seg(n);
        int mxv = 0;
        for (int x : a) if (x > mxv) mxv = x;
        int[] last = new int[mxv + 1];
        Arrays.fill(last, -1);

        int g = 0, ans = 0;
        for (int r = 0; r < n; r++) {
            int v = a[r], s = ((v & 1) == 0) ? 1 : -1, p = last[v];
            int L = Math.max(0, p), R = r - 1;
            if (L <= R) seg.upd(1, 0, n - 1, L, R, s);
            if (p == -1) g += s;
            last[v] = r;

            if (g == 0) ans = Math.max(ans, r + 1);
            if (r - 1 >= 0) {
                int pos = seg.fz(1, 0, n - 1, 0, r - 1);
                if (pos != Integer.MAX_VALUE) ans = Math.max(ans, r - pos);
            }
        }
        return ans;
    }
}