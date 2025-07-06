class FindSumPairs {
    // Step 1: Store the original arrays
    private int [] nums1;
    private int [] nums2;

    // Step 2: Create a frequency map to track counts of elements in num2
    private Map<Integer, Integer> freqMap;

    // Step 3: Constructor - initialize the data structure
    public FindSumPairs(int[] nums1, int[] nums2) {
        // 3.1: Assign arrays to class variables
        this.nums1 = nums1;
        this.nums2 = nums2;
        // 3.2: Initialize the frequency map for nums2
        freqMap = new HashMap<>();
        // 3.3: Populate the frequency map with initial values from nums2
        for(int num : nums2){
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
    }
    // Step 4: Method to add value to nums2[index]

    public void add(int index, int val) {
        // 4.1: Get the old value at the given index
        int oldVal = nums2[index];

        // 4.2: Compute the new value
        int newVal = oldVal + val;

        // 4.3: Update the frequency map - decrease count of old value
        freqMap.put(oldVal, freqMap.get(oldVal) - 1);

        // 4.4: If frequency of oldVal becomes 0, remove it
        if(freqMap.get(oldVal) == 0){
            freqMap.remove(oldVal);
        }

        // 4.5: Update frequency map - increase count of new value
        freqMap.put(newVal, freqMap.getOrDefault(newVal, 0) + 1);

        // 4.6: Update nums2 array
        nums2[index] = newVal;
    }

    // Step 5: Method to count pairs(i, j) such that nums1[i] + nums2[j] == tot

    public int count(int tot) {
        int result = 0;
        // 5.1: Loop through all elements of nums1
        for(int num1 : nums1){
            // 5.2: Calculate required complement from nums2
            int complement = tot - num1;

            // 5.3: Add frequency of complement from the freqMap
            result += freqMap.getOrDefault(complement, 0);
        }
        // 5.4: Return the final count
        return result;
    }
}

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs obj = new FindSumPairs(nums1, nums2);
 * obj.add(index,val);
 * int param_2 = obj.count(tot);
 */