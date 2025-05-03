class Solution {
    List<List<Integer>> master = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        rec(nums, 0, new LinkedList<Integer>());
        return master;
    }

    public void rec(int[] nums, int index, LinkedList<Integer> curr) {
        if (index == nums.length) {
            master.add(new LinkedList<>(curr));
            return;
        }

        curr.add(nums[index]);
        rec(nums, index + 1, curr);

        curr.removeLast();
        rec(nums, index + 1, curr);
    }
}
