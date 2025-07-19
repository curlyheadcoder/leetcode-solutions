class Solution {
    public int[] plusOne(int[] digits) {
        for(int i = digits.length - 1; i >= 0; i--){
            if(digits[i] < 9){
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        return java.util.stream.IntStream
            .concat(java.util.stream.IntStream.of(1), java.util.stream.IntStream.generate(() -> 0).limit(digits.length))
            .toArray();
    }
}