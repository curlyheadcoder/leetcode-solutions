class Solution {
    public int minimumDeletions(String word, int k) {
        //TODO 1: Count frequency of each character in the word
        Map<Character, Integer> freqMap = new HashMap<>();
        for(char c : word.toCharArray()){
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        // TODO 2: Store all frequencies in a list and sort it
        List<Integer> freqList = new ArrayList<>(freqMap.values());
        Collections.sort(freqList);   // Sorting helps in trying each frequency in increasing order

        // TODO 3: Initialize minDeletions with a large number
        int minDeletions = Integer.MAX_VALUE;
        
        // TODO 4: Try every unique frequency as the base frequency 
        // We will try to make all characters fall in base [base, base + k]
        for(int base : freqList){
            int deletions = 0;

            // TODO 5: For each unique frequency as the base frequency
            // - if it's < base, delete all of that character
            // - if it's > base + k, delete the extra occurences
            for(int freq : freqList){
                if(freq < base){
                    deletions += freq;   // Can't be raised, delete all
                }else if(freq > base + k){
                    deletions += freq - (base + k);   // Trim down to base + k
                }
                // If it's in the range [base, base + k], keep it
            } 
            // TODO 6: Keep track of the minimum deletions across all base attempts
            minDeletions = Math.min(minDeletions, deletions); 
        }

        return minDeletions;
    }
}
