class Solution {

    public int countPrimeSetBits(int left, int right) {

        // primes till 20
        boolean[] prime = new boolean[21];
        prime[2] = true;
        prime[3] = true;
        prime[5] = true;
        prime[7] = true;
        prime[11] = true;
        prime[13] = true;
        prime[17] = true;
        prime[19] = true;

        int count = 0;

        for (int num = left; num <= right; num++) {

            int bits = setBits(num);

            if (prime[bits]) {
                count++;
            }
        }

        return count;
    }

    // count number of 1s in binary
    private int setBits(int n) {
        int c = 0;

        while (n > 0) {
            c += n & 1;
            n >>= 1;
        }

        return c;
    }
}