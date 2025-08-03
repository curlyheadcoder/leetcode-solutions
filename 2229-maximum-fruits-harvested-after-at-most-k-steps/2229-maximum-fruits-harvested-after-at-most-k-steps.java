class Solution {
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int n = fruits.length;
        int maxFruits = 0;
        int left = 0;
        int currSum = 0;

        for (int right = 0; right < n; right++) {
            currSum += fruits[right][1];

            // Shrink the window if it's not reachable within k steps
            while (left <= right && !isReachable(fruits[left][0], fruits[right][0], startPos, k)) {
                currSum -= fruits[left][1];
                left++;
            }
            
            maxFruits = Math.max(maxFruits, currSum);
        }

        return maxFruits;
    }

    private boolean isReachable(int leftPos, int rightPos, int start, int k) {
        // go left first then right 
        int toLeftThenRight = Math.abs(start - leftPos) + (rightPos - leftPos);
        // go right first then left
        int toRightThenLeft = Math.abs(start - rightPos) + (rightPos - leftPos);
        return Math.min(toLeftThenRight, toRightThenLeft) <= k;
    }
}
