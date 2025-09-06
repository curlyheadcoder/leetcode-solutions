class Solution {
    public long minOperations(int[][] queries) {
        long total = 0;
        for(int [] q : queries){
            int l = q[0], r = q[1];
            long S = getOps(r) - getOps((long)l - 1L);
            total += (S + 1L) / 2L;   // ceil(S/2) 
        }
        return total;
    }
    private long getOps(long n){
        if(n <= 0L) return 0L;
        long res = 0L;
        long power = 1L;
        long ops = 0L;
        while(power <= n){
            ops += 1L;
            long next = power * 4L;
            long left = power;
            long right = Math.min(n, next - 1L);
            long count = right - left + 1L;
            res += count * ops;
            power = next;
        }
        return res;
    }
}