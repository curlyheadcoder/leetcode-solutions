class Solution {
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> temp = new ArrayList<>();
        solve(nums, 0, temp);  
        return res;
    }
    private void solve(int [] nums, int idx, List<Integer> temp){
        if(idx >= nums.length){
            res.add(new ArrayList<>(temp));
            return;
        }
        temp.add(nums[idx]);
        solve(nums, idx+1, temp);
        temp.remove(temp.size()- 1);
        solve(nums, idx + 1, temp);
    }
}