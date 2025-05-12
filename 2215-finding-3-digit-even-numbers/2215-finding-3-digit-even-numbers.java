class Solution {
    public int[] findEvenNumbers(int[] digits) {
        Set<Integer> set = new HashSet<>();
        int n = digits.length;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                for(int k = 0; k < n; k++){
                    if(i == j || j == k || i == k){
                        continue;
                    }
                    int num = digits[i] * 100 + digits[j] * 10 + digits[k];
                    if(num >= 100 && num % 2 == 0){
                        set.add(num);
                    }
                }
            }
        }
        int [] result = set.stream().sorted().mapToInt(Integer :: intValue).toArray();
        return result;
    }
}