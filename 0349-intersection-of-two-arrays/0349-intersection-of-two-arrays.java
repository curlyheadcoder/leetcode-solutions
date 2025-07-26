class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int n = nums2.length;
        int m = nums1.length;
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i = 0, j = 0;
        Set<Integer> resultSet = new HashSet<>();
        while(i < m && j < n){
            if(nums1[i] == nums2[j]){
                resultSet.add(nums1[i]);
                i++;
                j++;
            }else if(nums1[i] < nums2[j]){
                i++;
            }else{
                j++;
            }
        }
        int [] res = new int [resultSet.size()];
        int idx = 0;
        for(int ans : resultSet){
            res[idx++] = ans;
        }
        return res;
    }
}