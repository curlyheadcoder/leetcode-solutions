class Solution {
    private static final long MOD = (long) 1e9 + 7;
    public int countTrapezoids(int[][] points) {
        Map<Integer, Long> map = new HashMap<>();
        for(int i = 0; i < points.length; i++){
            int y = points[i][1];
            map.put(y, map.getOrDefault(y, 0L) + 1);
        }
        for(Map.Entry<Integer, Long> entry : map.entrySet()){
            long y = entry.getValue();
            y = y * (y-1) / 2;
            y %= MOD;
            entry.setValue(y);
        }
        long ans = 0, tot = 0;
        for(long y : map.values()){
            ans += y * tot;
            ans %= MOD;
            tot += y;
            tot %= MOD;
        }
        return (int) ans;
    }
}