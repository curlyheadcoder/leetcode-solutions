class Solution {
    class SegmentTree{
        int [] tree;
        int n;

        SegmentTree(int [] baskets){
            this.n = baskets.length;
            tree = new int [4*n];
            build(baskets, 1, 0, n-1);
        }
        void build(int [] arr, int idx, int l, int r){
            if(l == r){
                tree[idx] = arr[l];
                return;
            }
            int mid = (l+r)/2;
            build(arr, 2*idx, l, mid);
            build(arr, 2*idx + 1, mid + 1, r);
            tree[idx] = Math.max(tree[2*idx], tree[2 * idx + 1]);
        }
        void update (int idx, int l, int r, int pos){
            if(l == r){
                tree[idx] = 0;
                return;
            }
            int mid = (l+r) / 2;
            if(pos <= mid) update(2*idx, l, mid, pos);
            else update(2*idx +1, mid + 1, r, pos);
            tree[idx] = Math.max(tree[2*idx], tree[2*idx+1]);
        }
        int queryMax(int idx, int l, int r, int ql, int qr){
            if(qr < l || ql > r) return Integer.MIN_VALUE;
            if(ql <= l && r <= qr) return tree[idx];
            int mid = (l+r)/ 2;
            return Math.max(queryMax(2*idx, l, mid, ql, qr),
                            queryMax(2*idx+1, mid+1, r, ql,qr)); 
        }
        // Custom binary search to find first index with basket >= fruit
        int findIndex(int idx, int l, int r, int fruit){
            if(tree[idx] < fruit) return -1;
            if(l == r) return l;
            int mid = (l+r) / 2;
            if(tree[2*idx] >= fruit){
                return findIndex(2*idx, l, mid, fruit);
            }else{
                return findIndex(2*idx+1, mid+1, r, fruit);
            }
        }
    }
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n = baskets.length;
        SegmentTree segTree = new SegmentTree(baskets);
        int unplaced = 0;
        for(int fruit : fruits){
            int idx = segTree.findIndex(1, 0, n-1, fruit);
            if(idx == -1){
                unplaced++;
            }else{
                segTree.update(1, 0, n-1, idx);
            }
        }
        return unplaced;
    }
}