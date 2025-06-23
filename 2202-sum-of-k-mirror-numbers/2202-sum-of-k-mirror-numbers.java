class Solution {
    private int[] buffer = new int[100];

    public long kMirror(int k, int n) {
        long total = 0;
        int count = 0;
        int start = 1;

        while (count < n) {
            int end = start * 10;

            for (int type = 0; type < 2; type++) {
                for (int i = start; i < end && count < n; i++) {
                    long val = buildPalindrome(i, type == 0);

                    if (checkBaseKPalindrome(val, k)) {
                        total += val;
                        count++;
                    }
                }
            }

            start = end;
        }

        return total;
    }

    private long buildPalindrome(int num, boolean isOdd) {
        long result = num;
        int temp = isOdd ? num / 10 : num;

        while (temp > 0) {
            result = result * 10 + (temp % 10);
            temp /= 10;
        }

        return result;
    }

    private boolean checkBaseKPalindrome(long number, int base) {
        int length = 0;

        while (number > 0) {
            buffer[length++] = (int)(number % base);
            number /= base;
        }

        for (int i = 0; i < length / 2; i++) {
            if (buffer[i] != buffer[length - 1 - i]) {
                return false;
            }
        }

        return true;
    }
}
