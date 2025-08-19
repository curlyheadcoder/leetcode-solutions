class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        float [] sp = new float[target+1];
        float currSpeed = 0;
        int fleets = 0;
        for(int i = 0; i < position.length; i++){
            sp[position[i]] = (float)(target - position[i]) / speed[i];
        }
        for(int i = sp.length-1; i >= 0; i--){
            if(sp[i] > currSpeed){
                fleets++;
                currSpeed = sp[i];
            }
        }
        return fleets;
    }
}