class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        int n = nums.length;
        // Step 1: Map value   --> list of indices
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            map.putIfAbsent(nums[i], new ArrayList<>());
            map.get(nums[i]).add(i);
        }
        List<Integer> res = new ArrayList<>();
        // Step 2: Process each query
        for(int q : queries){
            int val = nums[q];
            List<Integer> list = map.get(val);

            // Only one occurence
            if(list.size() == 1){
                res.add(-1);
                continue;
            }
            int pos = Collections.binarySearch(list, q);

            int left = (pos - 1 + list.size()) % list.size();
            int right = (pos + 1) % list.size();

            int idx1 = list.get(left);
            int idx2 = list.get(right);

            int dist1 = Math.min(Math.abs(q - idx1), n - Math.abs(q - idx1));
            int dist2 = Math.min(Math.abs(q - idx2), n - Math.abs(q - idx2));

            res.add(Math.min(dist1, dist2));
        }
        return res;
    }
}