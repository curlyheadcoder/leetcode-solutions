class Solution {
    public int findLucky(int[] arr) {
        int [] countArray = new int [501];
        for(int a : arr){
            countArray[a]++;
        }
        for(int i = 500; i > 0; i--){
            if(i == countArray[i]){
                return i;
            }
        }
        return -1;
    }
}