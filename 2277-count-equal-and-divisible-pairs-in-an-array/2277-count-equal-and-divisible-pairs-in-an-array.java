class Solution {
    public int countPairs(int[] nums, int k) {
        int count = 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            map.computeIfAbsent(nums[i], x -> new ArrayList<>()).add(i);
        } 
        for(List<Integer> indices : map.values()){
            int size = indices.size();
            for(int i = 0; i < size; i++){
                for(int j = i+1; j < size; j++){
                    int idx1 = indices.get(i);
                    int idx2 = indices.get(j);
                    if((idx1 * idx2) % k == 0){
                        count++;
                    }
                }
            }
        }
        return count;
    }
}