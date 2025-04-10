class Solution {
    private String pattern;    // The String 's' to be repeated 
    private String bound;      // Current boundary as String ("start-1" or "finish")
    private Long[] dpCache;    // Use Long[] to allow null checks
    private int maxDigit;      // Digit limit

    public long numberOfPowerfulInt(long start, long finish, int limit, String s) {
        this.pattern = s;
        this.maxDigit = limit;

        // Count numbers from start to finish
        this.bound = String.valueOf(finish); 
        this.dpCache = new Long[20];
        long countUpToFinish = countValid(0, true);

        // Count numbers before start
        this.bound = String.valueOf(start - 1);
        this.dpCache = new Long[20];
        long countBeforeStart = countValid(0, true);

        return countUpToFinish - countBeforeStart;
    }

    private long countValid(int index, boolean isLimitTight) {
        // If the length left is less than pattern, no valid number can be formed 
        if (bound.length() - index < pattern.length()) {
            return 0;
        }

        // If only pattern-length characters left, compare directly
        if (bound.length() - index == pattern.length()) {
            if (!isLimitTight) return 1;
            return pattern.compareTo(bound.substring(index)) <= 0 ? 1 : 0;
        }

        if (!isLimitTight && dpCache[index] != null) {
            return dpCache[index];
        }

        long total = 0;
        int upper = isLimitTight ? (bound.charAt(index) - '0') : 9;
        upper = Math.min(upper, maxDigit); // All digits must be <= limit

        for (int digit = 0; digit <= upper; digit++) {
            boolean nextIsTight = isLimitTight && (digit == bound.charAt(index) - '0');
            total += countValid(index + 1, nextIsTight);
        }

        if (!isLimitTight) {
            dpCache[index] = total;
        }

        return total;
    }
}
