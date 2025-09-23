class Solution {
    public int compareVersion(String version1, String version2) {
        int i = 0, j = 0;
        int n = version1.length(), m = version2.length();

        while (i < n || j < m) {
            int a = 0, b = 0;

            // Parse next integer from version1
            while (i < n && version1.charAt(i) != '.') {
                a = a * 10 + (version1.charAt(i) - '0');
                i++;
            }

            // Parse next integer from version2
            while (j < m && version2.charAt(j) != '.') {
                b = b * 10 + (version2.charAt(j) - '0');
                j++;
            }

            if (a < b) return -1;
            if (a > b) return 1;

            // skip the '.' separator
            i++;
            j++;
        }

        return 0;
    }
}