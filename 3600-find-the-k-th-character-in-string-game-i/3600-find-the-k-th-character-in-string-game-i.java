class Solution {
    public char kthCharacter(int k) {
        int x = Integer.bitCount(k - 1);
        return (char)('a' + x);
    }
}