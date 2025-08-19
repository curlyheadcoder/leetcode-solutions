class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        for(int asteroid : asteroids){
            boolean destroyed = false;
            while(st.size() != 0 && asteroid < 0 && st.peek() > 0){
                if(st.peek() < -asteroid){
                    st.pop();    // smaller asteroid destroyed
                }else if(st.peek() == -asteroid){
                    st.pop();    //  equal size destroy both
                    destroyed = true;
                    break;
                }else{
                    destroyed = true;   // current asteroid destroyed
                    break;
                }
            }
            if(!destroyed){
                st.push(asteroid);
            }
        }
        // Convert stack into array (resultant array)
        int n = st.size();
        int [] resArray = new int [n];
        for(int i = n-1; i >= 0; i--){
            resArray[i] = st.pop();
        }
        return resArray;
    }
}