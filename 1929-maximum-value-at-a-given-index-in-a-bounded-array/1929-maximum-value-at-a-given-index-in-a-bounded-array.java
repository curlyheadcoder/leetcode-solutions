class Solution {
    public int maxValue(int n, int index, int maxSum) {
        int left = 1, right = maxSum;

        while (left < right) {
            int mid = (left + right + 1) / 2;

            if (isValid(n, index, maxSum, mid)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    private boolean isValid(int n, int index, int maxSum, int val) {
        long leftSum = calcSum(val - 1, index);
        long rightSum = calcSum(val - 1, n - index - 1);
        long total = leftSum + val + rightSum;
        return total <= maxSum;
    }

    private long calcSum(int high, int len) {
        if (high >= len) {
            long low = high - len + 1;
            return (long)(low + high) * len / 2;
        } else {
            long sum = (long)(high + 1) * high / 2;
            return sum + (len - high);
        }
    
    }
}