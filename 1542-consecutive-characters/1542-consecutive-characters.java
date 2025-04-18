class Solution {
    public int maxPower(String s) {
        int maxCount = 1;
        int currCount = 1;
        for(int i = 1; i < s.length(); i++){
            if(s.charAt(i) == s.charAt(i-1)){
                currCount++;
                maxCount =  Math.max(maxCount, currCount);
            }else{
                currCount = 1;
            }
        }
        return maxCount;
    }
}