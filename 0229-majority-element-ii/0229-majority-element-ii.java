class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int maj1 = 0, maj2 = 0;
        int c1 = 0, c2 = 0;
        int n = nums.length;
        for(int i = 0; i < n; i++){
            if(nums[i] == maj1){
                c1++;
            }else if(nums[i] == maj2){
                c2++;
            }else if(c1 == 0){
                maj1 = nums[i];
                c1 = 1;
            }else if(c2 == 0){
                maj2 = nums[i];
                c2 = 1;
            }else{
                c1--;
                c2--;
            }
        }
        List<Integer> ans = new ArrayList<>();
        int freq1 = 0, freq2 = 0;
        for(int num : nums){
            if(num == maj1) freq1++;
            else if(num == maj2) freq2++;
        }
        if(freq1 > n/3) ans.add(maj1);
        if(freq2 > n/3) ans.add(maj2);

        return ans;
    }
}