class Solution {
    public int xorAfterQueries(int[] nums, int[][] queries) {
        final long MOD = 1_000_000_007L;
        int n = nums.length;

        int [][] queriesCopy = new int[queries.length][];
        for(int i = 0; i < queries.length; i++){
            queriesCopy[i] = Arrays.copyOf(queries[i], queries[i].length);
        }
        for(int [] query : queriesCopy){
            int left = query[0], right = query[1], step = query[2];
            long mul = query[3] % MOD;
            for(int pos = left; pos <= right; pos += step){
                nums[pos] = (int)(((long) nums[pos] * mul) % MOD);
            }
        }
        int xorSum = 0;
        for(int val : nums){
            xorSum ^= val;
        }
        return xorSum;
    }
}