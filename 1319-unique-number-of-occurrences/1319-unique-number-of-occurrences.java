class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for(int a : arr){
            freqMap.put(a, freqMap.getOrDefault(a, 0)+1);
        }
        Set<Integer> freqSet = new HashSet<>();
        for(int freq : freqMap.values()){
            if(freqSet.contains(freq)){
                return false;
            }
            freqSet.add(freq);
        }
        return true;
    }
}