class Solution {
    public int maxSum(int[] nums) {
        Set<Integer> posElem = new HashSet<>();
        for(int num : nums){
            if(num > 0){
                posElem.add(num);
            }
        }
        if(posElem.isEmpty()){
            return Arrays.stream(nums).max().getAsInt();
        }
        return posElem.stream().mapToInt(Integer::intValue).sum();
    }
}