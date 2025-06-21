class Solution {
    public int minimumDeletions(String word, int k) {
        // TODO 1: Count frequency of each character in the word
        Map<Character, Integer> freqMap = new HashMap<>();
        for(char c : word.toCharArray()){
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        // TODO 2: Store all the frequencies in a list and sort it 
        List<Integer> freqList = new ArrayList<>(freqMap.values());
        Collections.sort(freqList);    // Storing helps in trying each frequency in inc order

        // TODO 3: Initialize minDeletions with a large number
        int minDeletions = Integer.MAX_VALUE;
        
        // Precompute prefix sum for fast deletion calculation
        int n = freqList.size();
        int [] prefixSum = new int [n];
        prefixSum[0] = freqList.get(0);
        for(int i = 1; i < n; i++){
            prefixSum[i] = prefixSum[i-1] + freqList.get(i);
        }
        // TODO 4: Try every unique frequency as the base frequency 
        // We will try to make all characters fall in base [base, base + k]
        for(int i = 0; i < n; i++){
            int base = freqList.get(i);
            int deletions = 0;

            // TODO 5: For each unique frequency as the base frequency 
            // if it is < base, delete all of that character
            // if it is > base + k, delete the extra occurences 
            // delete everything before index i
            deletions += (i > 0) ? prefixSum[i-1] : 0;
            // delete from the end if freq > base + k
            for(int j = i; j < n; j++){
                if(freqList.get(j) > base + k){
                    deletions += freqList.get(j) - (base + k);
                }
            }
            // TODO 6: Keep track of the minimum deletions across all base attempts
            minDeletions = Math.min(minDeletions, deletions);
        }
        return minDeletions;
    }
}