class Solution {
    public int subarrayBitwiseORs(int[] arr) {
        HashSet<Integer> prev = new HashSet<>();
        HashSet<Integer> curr = new HashSet<>();
        HashSet<Integer> res = new HashSet<>();

        for(int i = 0; i < arr.length; i++){
            for(int x : prev){
                curr.add(x | arr[i]);
                res.add(x | arr[i]);
            }
            curr.add(arr[i]);
            res.add(arr[i]);

            prev = new HashSet<>(curr);
            curr.clear();
        }
        return res.size();
    }
}