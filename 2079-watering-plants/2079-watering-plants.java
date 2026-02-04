class Solution {
    public int wateringPlants(int[] plants, int capacity) {
        int steps = 0, cap = capacity;
        for(int i = 0; i < plants.length; i++){
            if(plants[i] <= cap){
                steps++;
                cap = cap - plants[i];
            }else{
                cap = capacity;
                cap = cap - plants[i];
                steps = steps + (2*i) + 1;
            }
        }
        return steps;
    }
}