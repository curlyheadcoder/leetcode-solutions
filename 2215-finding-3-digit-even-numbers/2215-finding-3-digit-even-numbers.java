class Solution {
    public int[] findEvenNumbers(int[] digits) {
        List<Integer> res = new ArrayList<>();
        int [] freq = new int [10];
        // Count digit frequencies
        for(int digit : digits){
            freq[digit]++;
        }
        // Generate all valid 3-digit even numbers
        for(int i = 1; i <= 9; i++){
            if(freq[i] == 0) continue;
            freq[i]--;
            for(int j = 0; j <= 9; j++){
                if(freq[j] == 0) continue;
                freq[j]--;
                for(int k = 0; k <= 9; k += 2){
                    if(freq[k] == 0) continue;
                    int num = i * 100 + j * 10 + k;
                    res.add(num);
                }
                freq[j]++;
            }
            freq[i]++;
        }
        Set<Integer> unique = new TreeSet<>(res);
        int [] output = new int [unique.size()];
        int idx = 0;
        for(int num : unique){
            output[idx++] = num;
        }
        return output;
    }
}