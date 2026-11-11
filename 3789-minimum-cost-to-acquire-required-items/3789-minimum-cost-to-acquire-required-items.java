class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        long ans = 0;
        if(cost1 + cost2 <= costBoth){
            ans = 1L * cost1 * need1 + 1L * cost2 * need2;
        }else{
            int cnt3 = Math.min(need1, need2);
            ans = 1L * cnt3 * costBoth;
            need1 -= cnt3;
            need2 -= cnt3;

            if(need1 > 0){
                ans += 1L * need1 * Math.min(cost1, costBoth);
            }else if(need2 > 0){
                ans += 1L * need2 * Math.min(cost2, costBoth);
            }
        }
        return ans;
    }
}