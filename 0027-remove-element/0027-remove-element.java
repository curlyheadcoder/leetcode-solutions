class Solution {
    public int removeElement(int[] nums, int val) {
         int[] temp = new int[nums.length];
        int count = 0;
        for (int num : nums) {
            if (num != val) {
                temp[count++] = num;
            }
        }
        for (int i = 0; i < count; i++) {
            nums[i] = temp[i];
        }
        return count;
    }
}