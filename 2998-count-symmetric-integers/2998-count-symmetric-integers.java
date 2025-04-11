public class Solution {
    public int countSymmetricIntegers(int low, int high) {
        int count = 0;
        for (int num = Math.max(low, 10); num <= high; num++) {
            int len = (int) Math.log10(num) + 1;
            if (len % 2 != 0) continue; // skip odd-length numbers
            if (isSymmetric(num, len)) count++;
        }
        return count;
    }

    private boolean isSymmetric(int num, int len) {
        int half = len / 2;
        int divisor = (int) Math.pow(10, half);
        int left = num / divisor;
        int right = num % divisor;
        return digitSum(left) == digitSum(right);
    }

    private int digitSum(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}
