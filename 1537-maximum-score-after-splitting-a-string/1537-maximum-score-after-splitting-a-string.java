class Solution {
    public int maxScore(String s) {
        int maxScore = 0;
        for (int i = 1; i < s.length(); i++) {
            int leftZeros = 0, rightOnes = 0;
            for (int j = 0; j < i; j++) {
                if (s.charAt(j) == '0') leftZeros++;
            }
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(j) == '1') rightOnes++;
            }
            maxScore = Math.max(maxScore, leftZeros + rightOnes);
        }
        return maxScore;
    }
}
