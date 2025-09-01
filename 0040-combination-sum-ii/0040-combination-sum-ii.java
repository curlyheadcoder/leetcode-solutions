class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] candidates, int remain, int start) {
        if (remain == 0) {
            result.add(new ArrayList<>(tempList));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            // Skip duplicates at same recursion level
            if (i > start && candidates[i] == candidates[i-1]) continue;
            if (candidates[i] > remain) break; // early stop if number exceeds remaining target
            tempList.add(candidates[i]);
            // Move to next index because reuse is not allowed
            backtrack(result, tempList, candidates, remain - candidates[i], i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }
}
