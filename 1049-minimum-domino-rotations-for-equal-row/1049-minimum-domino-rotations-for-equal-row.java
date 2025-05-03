class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int [] countT = new int[7];
        int [] countB = new int [7];
        int [] countTB = new int [7];
        for(int i = 0; i < tops.length; i++){
            if(tops[i] == bottoms[i]){
                countTB[tops[i]] += 1;
            }else{
                countT[tops[i]] += 1;
                countTB[tops[i]] += 1;
                countB[bottoms[i]] += 1;
                countTB[bottoms[i]] += 1;
            }
        }
        for(int i = 1; i < 7; i++){
            if(countTB[i] == tops.length){
                return Math.min(countT[i], countB[i]);
            }
        }
        return -1;
    }
}