class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        int sum = 0, ans = 0;
        for(int a : apple) sum += a;
        Arrays.sort(capacity);
        for(int i = capacity.length-1; i >= 0; i--){
            sum -= capacity[i];
            ans++;
            if(sum <= 0) break;
        }
        return ans;
    }
}