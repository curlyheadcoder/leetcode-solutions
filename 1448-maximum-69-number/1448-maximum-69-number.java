class Solution {
    public int maximum69Number (int num) {
        List<Integer> list = new ArrayList<>();
        while(num > 0){
            list.add(num % 10);
            num /= 10;
        }
        int n = list.size();
        for(int i = n-1; i>= 0; i--){
            if(list.get(i) == 6){
                list.set(i, 9); break;
            }
        }
        int ans = 0;
        for(int i = n-1; i >= 0; i--){
            ans = ans * 10 + list.get(i);
        }
        return ans;
    }
}