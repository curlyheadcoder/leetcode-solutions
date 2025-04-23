class Solution {        // Optimized Version
    private int digitSum(int num){
        int sum = 0;
        while(num > 0){
            sum += (num%10);
            num /= 10;
        }
        return sum;
    }
    public int countLargestGroup(int n) {
        int [] count = new int[37];  // max digit sum for 9999 is 36
        int maxSize = 0;
        for(int i = 1; i <= n; i++){
            int sum = digitSum(i);
            count[sum]++;
            if(count[sum] > maxSize){
                maxSize = count[sum];
            }
        }
        int groups = 0;
        for(int c : count){
            if(c == maxSize){
                groups++;
            }
        }
        return groups;
    }
}