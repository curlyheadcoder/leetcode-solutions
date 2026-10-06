class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int cand1 = 0, cand2 = 0;
        int count1 = 0, count2 = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == cand1){
                count1++;
            }else if(nums[i] == cand2){
                count2++;
            }else if(count1 == 0){
                cand1 = nums[i];
                count1 = 1;
            }else if(count2 == 0){
                cand2 = nums[i];
                count2 = 1;
            }else{
                count1--;
                count2--;
            }
        }
        List<Integer> ans = new ArrayList<>();
        int n = nums.length;
        int freq1 = 0, freq2 = 0;
        for(int num : nums){
            if(num == cand1) freq1++;
            else if(num == cand2) freq2++;
        }
        if(freq1 > n/3) ans.add(cand1);
        if(freq2 > n/3) ans.add(cand2);
        return ans;
    }
}