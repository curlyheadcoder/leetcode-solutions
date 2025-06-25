class Solution {
    public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        long left = -10000000000L, right = 10000000000L;
        while(left < right){
            long mid = left + (right - left)/2;
            long count = countLessOrEqual(nums1, nums2, mid);
            if(count < k) left = mid + 1;
            else right = mid;
        }
        return left;
    }
    private long countLessOrEqual(int [] nums1, int [] nums2, long val){
        long count = 0;
        for(int num : nums1){
            if(num >= 0) count += countSmallerOrEqual(nums2, num, val);
            else count += countGreater(nums2, num, val);
        }
        return count;
    }
     // When num >= 0, count how many elements in nums2 satisfy num * y <= val
    private int countSmallerOrEqual(int [] nums2, int num, long val){
        int low = 0, high = nums2.length;
        while(low < high){
            int mid = (low + high)/2;
            if((long)num * nums2[mid] <= val) low = mid + 1;
            else high = mid;
        }
        return low;
    }
    // When num < 0, count how many elements in nums2 satisfy num * y > val
    // So we subtract that from total to get how many are ≤ val
    private int countGreater(int [] nums2, int num, long val){
        int low = 0, high = nums2.length;
        while(low < high){
            int mid = (low + high) / 2;
            if((long) num * nums2[mid] > val) low = mid + 1;
            else high = mid;
        }
        return nums2.length - low;
    }
}