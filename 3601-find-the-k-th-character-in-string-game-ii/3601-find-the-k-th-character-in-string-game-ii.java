class Solution {

    public char kthCharacter(long k, int[] operations) {
        int incrementCount = 0;

        while (k > 1) {
            int highestBit = 63 - Long.numberOfLeadingZeros(k);
            if ((1L << highestBit) == k) {
                highestBit--;
            }

            k -= (1L << highestBit);

            if (operations[highestBit] == 1) {
                incrementCount++;
            }
        }

        return (char) ('a' + (incrementCount % 26));
    }
}
