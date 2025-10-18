class Solution {
    public int maxPartitionsAfterOperations(String s, int k) {
        Map<Long, Integer> mem = new HashMap<>();
        return helper(s, 0, true, 0, k, mem) + 1;
    }

    private int helper(String s, int i, boolean canChange, int mask, int k, Map<Long, Integer> mem) {
        if (i == s.length()) return 0;

        long key = ((long) i << 27) | ((canChange ? 1L : 0L) << 26) | mask;
        if (mem.containsKey(key)) return mem.get(key);

        int res = getRes(s, i, canChange, mask, 1 << (s.charAt(i) - 'a'), k, mem);

        if (canChange) {
            for (int j = 0; j < 26; j++)
                res = Math.max(res, getRes(s, i, false, mask, 1 << j, k, mem));
        }

        mem.put(key, res);
        return res;
    }

    private int getRes(String s, int i, boolean nextCanChange, int mask, int newBit, int k, Map<Long, Integer> mem) {
        int nextMask = mask | newBit;
        if (Integer.bitCount(nextMask) > k)
            return 1 + helper(s, i + 1, nextCanChange, newBit, k, mem);
        return helper(s, i + 1, nextCanChange, nextMask, k, mem);
    }
}