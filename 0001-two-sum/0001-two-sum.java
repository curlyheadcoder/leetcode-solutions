class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        return IntStream.range(0, nums.length)
            .mapToObj(i -> {
                int diff = target - nums[i];
                if(map.containsKey(diff)){
                    return new int []{map.get(diff), i};
                }
                map.put(nums[i], i);
                return null;
            })
            .filter(Objects::nonNull)
            .findFirst()
            .orElse(new int []{-1,-1});
    }
}