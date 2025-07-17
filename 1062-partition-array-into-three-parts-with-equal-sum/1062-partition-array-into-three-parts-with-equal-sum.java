class Solution {
    public boolean canThreePartsEqualSum(int[] arr) {
        int totalSum  = 0;
        for(int a : arr){
            totalSum += a;
        }
        if(totalSum % 3 != 0) return false;

        int target = totalSum/3;
        int sum = 0, count = 0;

        for(int a : arr){
            sum += a;
            if(sum == target){
                count++;
                sum = 0;
            }
        }
        return count >= 3;
    }
}