class Solution {
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int n = arr.length;
        int count = 0;

        for (int i = 0; i < n - 2; i++) {
            int ai = arr[i];
            for (int j = i + 1; j < n - 1; j++) {
                int aj = arr[j];
                if (Math.abs(ai - aj) <= a) {
                    for (int k = j + 1; k < n; k++) {
                        int ak = arr[k];
                        if (Math.abs(aj - ak) <= b && Math.abs(ai - ak) <= c) {
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }
}
