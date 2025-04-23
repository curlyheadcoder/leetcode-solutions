class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int n = capacity.length;
        int [] required = new int [n];
        // Step 1 -> Find required rocks for every bag
        for(int i = 0; i < n; i++){
            required[i] = capacity[i] - rocks[i];
        }
        // Step 2 -> Sort the required array
        Arrays.sort(required);

        // Step 3 -> Greedy fill 
        int fullBags = 0;
        for(int i = 0; i < n; i++){
            if(required[i] <= additionalRocks){
                additionalRocks -= required[i];
                fullBags++;;
            }else{
                break;
            }
        }
        return fullBags;
    }
}