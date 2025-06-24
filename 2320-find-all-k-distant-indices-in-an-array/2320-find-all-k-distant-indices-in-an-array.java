class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        int n = nums.length;
        boolean [] isValid = new boolean[n];
        List<Integer> res = new ArrayList<>();
        // Step 1: First collect all the indices where nums[i] == key
        for(int i = 0; i < n; i++){
            if(nums[i] == key){
                // Step 2: For each i, mark all the indices from i - k to i + k as valid
                int start = Math.max(0, i - k);
                int end = Math.min(n - 1, i + k);

                for(int j = start; j <= end; j++){
                    isValid[j] = true;
                }
            }
        }
        // Step 3: Collect all marked indices 
        for(int i = 0; i < n; i++){
            if(isValid[i]){
                res.add(i);
            }
        }
        return res;
    }
}