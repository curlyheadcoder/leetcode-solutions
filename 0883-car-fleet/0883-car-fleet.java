class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        Integer [] indices = new Integer[n];
        for(int i = 0; i < n; i++){
            indices[i] = i;
        }
        // Sort the cars by position descending (closest to the target first)
        Arrays.sort(indices, (a, b) -> position[b] - position[a]);

        Stack<Double> st = new Stack<>();
        for(int i : indices){
            double time = (double) (target - position[i]) / speed[i];
            if(st.size() == 0 || time > st.peek()){
                st.push(time);  // new fleet
            }
            // else current car joins fleet on top of stack
        }
        return st.size();
    }
}