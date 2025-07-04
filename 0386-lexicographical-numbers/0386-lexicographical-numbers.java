class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();
        int curr = 1;
        for(int i = 0; i < n; i++){
            res.add(curr);
            if(curr * 10 <= n){
                curr = curr * 10;
            }else{
                if(curr >= n){
                    curr /= 10;
                }
                curr++;
                while(curr % 10 == 0){
                    curr /= 10;
                }
            }

        }
        return res;
    }
}