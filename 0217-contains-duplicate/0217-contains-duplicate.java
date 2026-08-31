class Solution {
    public boolean containsDuplicate(int[] nums) {
        // HashSet to store the numbers
        Set<Integer> intSet = new HashSet<>();
        // iterate over the array
        for(int num : nums){
            // check the number in the hashset
            if(intSet.contains(num)) return true;
            // add the number into the hashset
            intSet.add(num);
        }
        return false;
    }
}