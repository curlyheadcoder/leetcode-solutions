class Solution {
    private int digitSum(int n){
        int sum = 0;
        while(n > 0){
            sum += (n%10);
            n /= 10;
        }
        return sum;
    }
    public int countLargestGroup(int n) {
        HashMap <Integer, Integer> mapSize = new HashMap<>();
        int maxSize = 0;
        // Calculate digit sum for each num and update map size
        for(int i = 1; i <= n; i++){
            int sum = digitSum(i);
            mapSize.put(sum, mapSize.getOrDefault(sum, 0)+1);
            maxSize = Math.max(maxSize, mapSize.get(sum));
        }
        // Count the num of groups with the maximum size
        int count = 0;
        for(int map : mapSize.values()){
            if(map == maxSize){
                count++;
            }
        }
        return count;
    }
}