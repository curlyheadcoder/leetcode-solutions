class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int [] res = new int [nums1.length];
        for(int i = 0; i < nums1.length; i++){
            int num = nums1[i];
            // Step 1: Find index of num in nums2
            int idx = -1;
            for(int j = 0; j < nums2.length; j++){
                if(nums2[j] == num){
                    idx = j;
                    break;
                }
            }
            // Step 2: From that index, find next greater to the right
            int nextGreater = -1;
            for(int j = idx + 1; j < nums2.length; j++){
                if(nums2[j] > num){
                    nextGreater = nums2[j];
                    break;
                }
            }
            res[i] = nextGreater;
        }
        return res;
    }
}