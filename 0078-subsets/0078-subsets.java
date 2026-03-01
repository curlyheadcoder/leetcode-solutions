class Solution {
    // private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        solve(nums, 0, new ArrayList<>(), res);  
        return res;
    }
    private void solve(int [] nums, int idx, List<Integer> curr, List<List<Integer>> res){
        if(idx == nums.length){
            res.add(new ArrayList<>(curr));
            return;
        }
        // choose 
        curr.add(nums[idx]);
        solve(nums, idx+1, curr, res);
        // Backtrack
        curr.remove(curr.size()-1);
        // Not choose
        solve(nums, idx+1, curr, res);
    }
}