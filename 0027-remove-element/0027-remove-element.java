class Solution {
    public int removeElement(int[] nums, int val) {
        int j = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != val){
                nums[j++] = nums[i];
                // j++;
            }
        }
        return j;
    }
}

/*
        // [3,2,2,3]  , val = 3
        // [2,2,_,_] 
        // [1,1,1,1]  , val = 1;
        // 0
        

*/