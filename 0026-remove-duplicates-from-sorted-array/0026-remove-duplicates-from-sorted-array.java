class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int temp[] = new int [n];
        temp[0] = nums[0];
        int res = 1;
        for(int i = 1; i < n; i++){
            if(temp[res-1] != nums[i]){
                temp[res] = nums[i];
                res++;
            }
        }
        for(int i = 0; i < res; i++){
            nums[i] = temp[i];
        }
        return res;
    }
}