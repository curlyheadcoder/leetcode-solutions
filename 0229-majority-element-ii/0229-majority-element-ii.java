class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int maj1 = 0, maj2 = 0;
        int count1 = 0, count2 = 0;
        int n = nums.length;

        for(int i = 0; i < nums.length; i++){
            if(nums[i] == maj1){
                count1++;
            }else if(nums[i] == maj2){
                count2++;
            }else if(count1 == 0){
                maj1 = nums[i] ;
                count1 = 1;
            }else if(count2 == 0){
                maj2 = nums[i];
                count2 = 1;
            }else{
                count1--;
                count2--;
            }
        }
        // verification

        int freq1 = 0, freq2 = 0;
        List<Integer> res = new ArrayList<>();
        for(int num : nums){
            if(num == maj1) freq1++;
            else if(num == maj2) freq2++;
        }

        if(freq1 > n/3) res.add(maj1);
        if(freq2 > n/3) res.add(maj2);

        return res;
    }
}