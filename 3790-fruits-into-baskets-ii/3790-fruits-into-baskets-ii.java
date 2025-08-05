class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n = fruits.length;
        boolean [] usedFruits = new boolean [n];
        int unplacedFruits = 0;

        for(int i = 0; i < n; i++){
            boolean isPlaced = false;
            for(int j = 0; j < n; j++){
                if(baskets[j] >= fruits[i] && !usedFruits[j]){
                    usedFruits[j] = true;    // this basket is used now to store fruits
                    isPlaced = true;
                    break;
                } 
            }
            if(!isPlaced){
                unplacedFruits++;
            }
        }
        return unplacedFruits;
    }
}

/*
Input: fruits = [4,2,5],  basket = [3,5,4]

*/