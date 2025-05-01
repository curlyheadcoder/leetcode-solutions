class Solution {
    public int lastStoneWeight(int[] stones) {
        Arrays.sort(stones);
        int n = stones.length;
        while(n > 1){
            int x = stones[n-1];
            int y = stones[n-2];
            if(x == y){
                n -= 2;
            }else{
                stones[n-2] = x - y;
                n--;
                Arrays.sort(stones, 0, n);
            }
        }
        return n == 0 ? 0 : stones[0];
    }
}