class Solution {
    public long minimumDifference(int[] nums) {
        int n = nums.length/3;
        int len = nums.length;
        long [] prefixSum = new long [len]; // Store min sumFirst at each split
        long [] suffixSum = new long[len];  // Store max sumSecond at each point
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        long sum = 0;
        // Compute prefix sum: smallest n elements from left side
        for(int i =0; i < 2*n; i++){
            sum += nums[i];
            maxHeap.offer(nums[i]);

            if(maxHeap.size() > n){
                sum -= maxHeap.poll();  // Remove largest to keep n smallest 
            }

            if(maxHeap.size() == n){
                prefixSum[i] = sum;
            }
        }
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        sum = 0;
        // Compute suffix sum: largest n elements from right side
        for(int i = len -1 ; i >= n; i--){
            sum += nums[i];
            minHeap.offer(nums[i]);

            if(minHeap.size() > n){
                sum -= minHeap.poll();   // Remove smallest to keep n largest
            }

            if(minHeap.size() == n){
                suffixSum[i] = sum;
            }
        }
        long minDiff = Long.MAX_VALUE;
        // Compare prefix and suffix at valid split points 
        for(int i = n - 1; i < 2 * n; i++){
            long diff = prefixSum[i] - suffixSum[i+1];
            minDiff = Math.min(minDiff, diff);
        }
        return minDiff;
    }
}