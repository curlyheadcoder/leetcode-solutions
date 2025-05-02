class Solution {
    public String pushDominoes(String dominoes) {
        int n = dominoes.length();
        char[] arr = new char[n + 2];
        arr[0] = 'L';
        arr[n + 1] = 'R';
        for (int i = 1; i <= n; i++) {
            arr[i] = dominoes.charAt(i - 1);
        }

        int j = 0;
        for (int k = 1; k < arr.length; k++) {
            if (arr[k] != '.') {
                if (k - j > 1) {
                    solveConfiguration(arr, j, k);
                }
                j = k;
            }
        }

        StringBuilder res = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            res.append(arr[i]);
        }
        return res.toString();
    }

    public static void solveConfiguration(char[] arr, int i, int j) {
        if (arr[i] == 'L' && arr[j] == 'L') {
            for (int k = i + 1; k < j; k++) {
                arr[k] = 'L';
            }
        } else if (arr[i] == 'R' && arr[j] == 'R') {
            for (int k = i + 1; k < j; k++) {
                arr[k] = 'R';
            }
        } else if (arr[i] == 'R' && arr[j] == 'L') {
            int left = i + 1;
            int right = j - 1;
            while (left < right) {
                arr[left++] = 'R';
                arr[right--] = 'L';
            }
            // if left == right (odd distance), middle stays '.'
        }
        // if arr[i] == 'L' && arr[j] == 'R', do nothing
    }
}
