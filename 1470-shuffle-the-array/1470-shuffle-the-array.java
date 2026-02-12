class Solution {
    public int[] shuffle(int[] nums, int n) {
        int [] ans = new int[2*n];
        int p1 = 0;
        for(int p2 = 0; p2 < 2*n; p2 = p2 + 2){
            ans[p2] = nums[p1];
            ans[p2+1] = nums[n+p1];
            p1++;
        }
        return ans;
    }
}