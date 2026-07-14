class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> res = new ArrayList<>();
        for(int st = 1; st <= 9; st++){
            int num = 0;
            for(int digit = st; digit <= 9; digit++){
                num = num * 10 + digit;
                if(num >= low && num <= high){
                    res.add(num);
                }
            }
        }
        Collections.sort(res);
        return res;
    }
}