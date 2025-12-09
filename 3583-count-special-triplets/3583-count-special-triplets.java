class Solution {
    static final int M = (int)1e9 + 7;

    public int specialTriplets(int[] nums) {
        Map<Integer, Integer> validI = new HashMap<>();
        Map<Integer, Integer> validJ = new HashMap<>();

        int result = 0;

        for (int num : nums) {

            // If num is valid k (k must be even)
            if (num % 2 == 0) {
                result = (result + validJ.getOrDefault(num / 2, 0)) % M;
            }

            
            int updatedJ = (validJ.getOrDefault(num, 0) +
                            validI.getOrDefault(num * 2, 0)) % M;
            validJ.put(num, updatedJ);

            validI.put(num, validI.getOrDefault(num, 0) + 1);
        }

        return result;
    }
}