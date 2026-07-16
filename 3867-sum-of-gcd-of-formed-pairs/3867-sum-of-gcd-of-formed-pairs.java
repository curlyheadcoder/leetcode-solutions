class Solution {
    public long gcdSum(int[] nums) {
        int n = nums.length;
        int [] prefixGcd = new int [n];
        int maxEl = -1;
        for(int i = 0; i < n; i++){
            maxEl = Math.max(maxEl, nums[i]);
            prefixGcd[i] = gcd(nums[i], maxEl);
        }
        Arrays.sort(prefixGcd);
        long res = 0;
        int i = 0;
        int j = n-1;
        while(i < j){
            res += gcd(prefixGcd[i], prefixGcd[j]);
            i++;
            j--;
        }
        return res;
    }
    private int gcd(int a, int b){
        while(b != 0){
            int t = b;
            b = a % b;
            a = t;
        }
        return a;
    }
}