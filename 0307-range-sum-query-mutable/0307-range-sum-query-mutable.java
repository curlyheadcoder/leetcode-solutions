class NumArray {
    private int [] nums;
    private SegmentTree segmentTree;

    public NumArray(int[] nums) {
        this.nums = nums;
        this.segmentTree = new SegmentTree(nums);
    }
    
    public void update(int index, int val) {
        segmentTree.update(index, val);
    }
    
    public int sumRange(int left, int right) {
        return segmentTree.sumRange(left, right);
    }

    private class SegmentTree{
        private int[] tree;
        private int n;

        public SegmentTree(int [] nums){
            n = nums.length;
            tree = new int[4 * n];
            buildTree(nums, 0, 0, n-1);
        }

        private void buildTree(int [] nums, int node, int start, int end){
            if(start == end){
                tree[node] = nums[start];
            }else{
                int mid = start + (end - start)/2;
                buildTree(nums, 2* node + 1, start, mid);
                buildTree(nums, 2 * node + 2, mid + 1, end);
                tree[node] = tree[2 * node + 1] + tree[2 * node + 2];
            }
        }

        public void update(int index, int val){
            updateTree(0, 0, n-1, index, val);
        }

        private void updateTree(int node, int start, int end, int idx, int val){
            if(start == end){
                tree[node] = val;
            }else{
                int mid = start + (end - start)/2;
                if(start <= idx && idx <= mid){
                    updateTree(2 * node + 1, start, mid, idx, val);
                }else{
                    updateTree(2 * node + 2, mid + 1, end, idx, val);
                }
                tree[node] = tree[2 * node + 1] + tree[2 * node + 2];
            }
        }
        public int sumRange(int left, int right){
            return sumRangeTree(0, 0, n-1, left, right);
        }
        
        private int sumRangeTree(int node, int start, int end, int l, int r){
            if(r < start || end < l){
                return 0;
            }
            if(l <= start && end <= r){
                return tree[node];
            }
            int mid = start + (end - start)/2;
            int leftSum = sumRangeTree(2 * node + 1, start, mid, l, r);
            int rightSum = sumRangeTree(2 * node + 2, mid + 1, end, l, r);
            return leftSum + rightSum;
        }
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */