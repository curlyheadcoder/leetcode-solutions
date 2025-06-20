class Solution {
    public int maxDistance(String s, int k) {
        int maxMD = 0;
        int east = 0;
        int west = 0;
        int north = 0;
        int south = 0;

        for (int i = 0; i < s.length(); i++) {
            char dir = s.charAt(i);
            if (dir == 'W') west++;
            else if (dir == 'E') east++;
            else if (dir == 'N') north++;
            else if (dir == 'S') south++;

            int currMD = Math.abs(east - west) + Math.abs(north - south);
            int steps = i + 1;
            int wasted = steps - currMD;
            int extra = wasted != 0 ? Math.min(2 * k, wasted) : 0;
            int finalCurrMD = currMD + extra;
            maxMD = Math.max(maxMD, finalCurrMD);
        }

        return maxMD;
    }
}
