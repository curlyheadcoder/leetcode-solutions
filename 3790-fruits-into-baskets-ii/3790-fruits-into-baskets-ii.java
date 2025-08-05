class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n = fruits.length;
        boolean[] used = new boolean[n];
        int unplaced = n;
        
        for (int fruitQty : fruits) {
            for (int j = 0; j < n; j++) {
                if (!used[j] && baskets[j] >= fruitQty) {
                    used[j] = true;
                    unplaced--;
                    break; // move to next fruit
                }
            }
        }
        
        return unplaced;
    }
}
