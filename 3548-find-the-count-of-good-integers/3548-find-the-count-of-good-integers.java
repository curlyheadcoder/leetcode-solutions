public class Solution {
    private long count = 0;
    private Set<String> visited = new HashSet<>();
    private long[] factorial = new long[11];

    public long countGoodIntegers(int n, int k) {
        computeFactorials();
        char[] number = new char[n];
        Arrays.fill(number, ' ');
        generatePalindromes(0, n, k, number);
        return count;
    }

    private void computeFactorials() {
        factorial[0] = 1;
        for (int i = 1; i <= 10; i++) {
            factorial[i] = factorial[i - 1] * i;
        }
    }

    private void generatePalindromes(int pos, int n, int k, char[] number) {
        if (pos >= (n + 1) / 2) {
            String numStr = new String(number);
            if (Long.parseLong(numStr) % k != 0) return;

            char[] sorted = numStr.toCharArray();
            Arrays.sort(sorted);
            String sortedStr = new String(sorted);
            if (visited.contains(sortedStr)) return;
            visited.add(sortedStr);

            int[] freq = new int[10];
            for (char c : sorted) freq[c - '0']++;

            long totalPermutations = factorial[n];
            for (int f : freq) totalPermutations /= factorial[f];

            long invalid = 0;
            if (freq[0] > 0) {
                freq[0]--;
                long temp = factorial[n - 1];
                for (int f : freq) temp /= factorial[f];
                invalid = temp;
            }

            count += totalPermutations - invalid;
            return;
        }

        for (char c = (pos == 0) ? '1' : '0'; c <= '9'; c++) {
            number[pos] = c;
            number[n - pos - 1] = c;
            generatePalindromes(pos + 1, n, k, number);
        }
    }
}
