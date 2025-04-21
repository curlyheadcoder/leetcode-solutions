class Solution {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        // hidden sequence length -> n + 1
        // differences = n    (diffrences[i] = hidden[i+1] - hidden[i])
        long ans = 0, max = 0, min = 0;
        for(int diff : differences){
            ans += diff;
            min = Math.min(ans, min);
            max = Math.max(ans, max);
        }
        return (int)Math.max(0, upper-lower - (max-min)+1);
    }

}