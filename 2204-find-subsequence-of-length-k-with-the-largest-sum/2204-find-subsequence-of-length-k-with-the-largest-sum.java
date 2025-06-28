class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        int n = nums.length;
        // Min-heap to keep track of top k elements by value
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);

        for(int i = 0; i < n; i++){
            pq.offer(new int[] {nums[i], i});
            if(pq.size() > k){
                pq.poll();  // remove smallest value
            }
        }
        // Collect the top k elements with their original indices
        List<int[]> selected = new ArrayList<>();
        while(!pq.isEmpty()){
            selected.add(pq.poll());
        }
        // Sort seleceted elements by original index to maintain ordeer
        selected.sort((a,b) -> a[1] - b[1]);
        int [] res = new int [k];
        for(int i = 0; i < k; i++){
            res[i] = selected.get(i)[0];
        }
        return res;
    }
}