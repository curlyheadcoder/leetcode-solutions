class Solution {
    public long countGood(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        long total = 0;
        int left = 0;
        long pairs = 0;
        for(int right = 0; right < nums.length; right++){
            int num = nums[right];
            int count = map.getOrDefault(num, 0);
            pairs = pairs + count;
            map.put(num, count+1);
            while(pairs >= k){
                total = total + (nums.length - right);
                int leftNum = nums[left];
                int leftCount = map.get(leftNum);
                pairs = pairs - (leftCount - 1);
                map.put(leftNum, leftCount - 1);
                left++;
            }
        }
        return total;
    }
}