class Solution {
    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);  // sort the array to group the closest elements together
        int n = nums.length;
        List<int []> grouped = new ArrayList<>();
        for(int i = 0; i < n; i += 3){
            int x = nums[i];
            int y = nums[i+1];
            int z = nums[i+2];
            if(z - x > k){
                return new int [0][0];       // invalid group
            }
            grouped.add(new int[] {x,y,z});  // valid group
        }
        return grouped.toArray(new int [grouped.size()][]);
    }
}